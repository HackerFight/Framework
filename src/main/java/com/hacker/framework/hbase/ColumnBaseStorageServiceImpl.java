package com.hacker.framework.hbase;

import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public class ColumnBaseStorageServiceImpl implements ColumnBaseStorageService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ColumnBaseStorageServiceImpl.class);

    private static final Logger OTS_DAL_LOGGER = LoggerFactory.getLogger("OTS_DAL");

    @Autowired
    private OtsClientService otsClientService;

    /**
     * 这个是spring的
     */
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    //重试次数
    private static final int RETRY_TIME = 3;

    @Override
    public boolean createSchema(String tableName) {
        return this.otsClientService.createSchema(tableName);
    }

    @Override
    public boolean removeSchema(String tableName) {
        return this.otsClientService.deleteSchema(tableName);
    }

    @Override
    public boolean saveRow(String tableName, RowUnit rowUnit) {
        int failCount;
        for(failCount = 0; failCount < RETRY_TIME; failCount++){

            try {
                switch (failCount){
                    case 0:
                        this.otsClientService.saveRow(tableName, rowUnit.getRowKey(), rowUnit);
                        break;
                    case 1:
                        this.otsClientService.saveRowRetry(tableName, rowUnit.getRowKey(), rowUnit);
                        break;
                    case 2:
                        this.otsClientService.saveRowRetry2(tableName, rowUnit.getRowKey(), rowUnit);
                        break;
                    default:
                        //不会执行到这里
                        throw new RuntimeException("OTS 保存失败");
                }

                Thread.sleep(50);

                RowUnit exist = getRow(tableName, rowUnit.getRowKey());

                if (null != exist){
                    break;
                }
            } catch (Exception e) {
                LoggerUtil.error(LOGGER, e, tableName, "保存到OTS 发生异常-已重试次数：" + failCount);
            }
        }

        if (failCount >= RETRY_TIME){
            LoggerUtil.error(LOGGER, tableName, "保存到OTS发生异常-数据丢失");
            //这个做日志监控的
            LoggerUtil.monitor(OTS_DAL_LOGGER, tableName, "saveRowRetry3", true, 0);
            return false;
        }
        return true;
    }

    @Override
    public boolean asyncSaveRow(String tableName, RowUnit rowUnit) {
        //阿里的 TracerRunnable 抽象类实现了 Runnable，对功能进行了加强
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                saveRow(tableName, rowUnit);
            }
        });
        return true;
    }

    @Override
    public RowUnit getRow(String tableName, String rowKey) {
        return this.otsClientService.getRow(tableName, rowKey);
    }

    @Override
    public boolean deleteRow(String tableName, String rowKey) {
        return this.otsClientService.deleteRow(tableName, rowKey);
    }
}
