package com.hacker.framework.component.executor;

import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.ex.ComException;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.service.CommonQueryResult;
import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Created by hacker on 2019/4/16 0016-下午 10:02
 *
 * @desc
 */
public class CacheWriteComTpl extends CacheBaseComTpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheWriteComTpl.class);

    @Override
    public Object doRun(MetaComConfig metaComConfig, PipelineContext ctx) {

        if (StringUtils.isEmpty(metaComConfig.getComponentCode())){
            throw new ComException(metaComConfig.getComponentCode(), GdfErrorEnum.COM_CONF_EMPTY_ERROR);
        }

        CommonQueryResult commonQueryResult = ctx.getCommonQueryResult();
        if (null == commonQueryResult || CollectionUtils.isEmpty(commonQueryResult.getResultMap())){
            LoggerUtil.warn(LOGGER, "result or cache is empty");
            return null;
        }

        if (commonQueryResult.isFromCache() || !commonQueryResult.isSuccess()){
            //1.结果为false 不缓存
            //2.如果数据是直接从缓存中读取的，不能在写到缓存中，这样会更新缓存的时间
            return null;
        }

        //保存至hbase中
        return null;
    }
}
