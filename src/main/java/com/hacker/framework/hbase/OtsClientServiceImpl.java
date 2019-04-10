package com.hacker.framework.hbase;

import com.aliyun.openservices.ots.OTSClient;
import com.aliyun.openservices.ots.model.*;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public class OtsClientServiceImpl implements OtsClientService{

    private static final Logger LOGGER = LoggerFactory.getLogger(OtsClientServiceImpl.class);

    @Autowired
    private OtsAdapterBuilder otsAdapterBuilder;

    /**
     * 主键对应key，这里会将 OTS 主键列封装成类似 Hbase 的 rowkey
     */
    private static final String PRIMARY_KEY_COLUMN = "rowkey";
    /**
     * 版本管理
     */
    private static final String TIME_VERSION = "timeVersion";

    /**
     * 默认列族
     */
    private static final String COL_FAMILY = "f";

    @Override
    public boolean createSchema(String tableName) {
        try {
            return operate(otsClient -> {
                CapacityUnit capacityUnit = new CapacityUnit();
                TableMeta tableMeta = new TableMeta(tableName);
                //我看他们用的是 addPrimaryKeyColumn 方法
                tableMeta.addPrimaryKey(PRIMARY_KEY_COLUMN, PrimaryKeyType.STRING);
                CreateTableRequest request = new CreateTableRequest();
                request.setTableMeta(tableMeta);
                request.setReservedThroughput(capacityUnit);
                //应该是版本的问题，我没有看到此方法
                //otsClient.createTable(request);
                return true;
            });
        } catch (Exception e) {
            throw new GdfException(e, GdfErrorEnum.OTS_EXCEPTION);
        }
    }

    @Override
    public boolean existsSchema(String tableName) {
        try {
            return operate(otsClient -> {
                List<String> tables = otsClient.listTables();
                return tables.contains(tableName);
            });
        } catch (Exception e) {
            throw new GdfException(e, GdfErrorEnum.OTS_EXCEPTION);
        }
    }

    @Override
    public boolean deleteSchema(String tableName) {
        try {
            return operate(otsClient -> {
    //            DeleteTableRequest request = new DeleteTableRequest(tableName);
    //            没有看到此方法，而是下面的方法直接删除
    //            otsClient.deleteTable(request);
                otsClient.deleteTable(tableName);
                return true;
            });
        } catch (Exception e) {
            throw new GdfException(e, GdfErrorEnum.OTS_EXCEPTION);
        }
    }

    @Override
    public boolean saveRow(String tableName, String rowKey, RowUnit rowUnit) {
       if (null == rowUnit){
           return false;
       }

        try {
            return operate(otsClient -> {
                //没有看到此方法
               // RowPutChange rowPutChange = new RowPutChange(tableName);
                RowPutChange rowPutChange = new RowPutChange();

    //            RowPrimaryKey rowPrimaryKey = new RowPrimaryKey();
    //            rowPrimaryKey.addPrimaryKeyColumn(PRIMARY_KEY_COLUMN, PrimaryKeyValue.fromString(rowUnit.getRowKey()));
    //            rowPutChange.setPrimaryKey(rowPrimaryKey); // 无此方法
                rowPutChange.addPrimaryKey(PRIMARY_KEY_COLUMN,PrimaryKeyValue.fromString(rowUnit.getRowKey()));

                List<CellUnit> cellUnits = rowUnit.getCellUnits();

                for (CellUnit cellUnit : cellUnits) {
                    String family = cellUnit.getColumnFamily();
                    if (StringUtils.isEmpty(family)){
                        continue;
                    }

                    String key = cellUnit.getColumn();
                    if (StringUtils.isEmpty(key)){
                        continue;
                    }

                    String value = cellUnit.getValue();
                    if (StringUtils.isEmpty(value)){
                        value = "";
                    }

                    rowPutChange.addAttributeColumn(key, ColumnValue.fromString(value));
                    //设置数据版本
                    rowPutChange.addAttributeColumn(TIME_VERSION, ColumnValue.fromLong(rowUnit.getTimeStamp()));
                    //无此方法
                    //rowPutChange.setCondition(new Condition(RowExistenceExpectation.EXPECT_NOT_EXIST));
                    PutRowRequest putRowRequest = new PutRowRequest(rowPutChange);

                    //无此方法
                   // PutRowResult putRowResult = otsClient.putRow(putRowRequest);
                    PutRowResult putRowResult = null;

                    if (LOGGER.isDebugEnabled()){
                        LOGGER.debug(MessageFormat.format("OTS数据插入成功，消耗的写 CapacityUnit 为：[{0}]",
                                putRowResult.getConsumedCapacity().getCapacityUnit().getWriteCapacityUnit()));
                    }
                }

                return true;
            });
        } catch (Exception e) {
            throw new GdfException(e, GdfErrorEnum.OTS_EXCEPTION);
        }
    }

    @Override
    public boolean saveRowRetry(String tableName, String rowKey, RowUnit rowUnit) {
        return saveRow(tableName, rowKey, rowUnit);
    }

    @Override
    public boolean saveRowRetry2(String tableName, String rowKey, RowUnit rowUnit) {
        return saveRow(tableName, rowKey, rowUnit);
    }

    @Override
    public RowUnit getRow(String tableName, String rowKey) {

        return null;
    }

    @Override
    public boolean deleteRow(String tableName, String rowKey) {
        return false;
    }

    /**
     * 函数式接口
     * @param operateFunction
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> T operate(OtsFunctions<OTSClient, T> operateFunction) throws Exception{
        OTSClient otsClient = this.otsAdapterBuilder.build();
        return operateFunction.apply(otsClient);
    }
}
