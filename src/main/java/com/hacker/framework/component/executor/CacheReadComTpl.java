package com.hacker.framework.component.executor;

import com.google.common.cache.CacheBuilder;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.hbase.HbaseCacheConfig;
import sun.security.util.Cache;

/**
 * Created by hacker on 2019/4/16 0016-下午 10:01
 *
 * @desc
 */
public class CacheReadComTpl extends CacheBaseComTpl {

    @Override
    public Object doRun(MetaComConfig metaComConfig, PipelineContext ctx) {

        //加载缓存相关的配置，这个方法来自于父类，因为读写缓存都要用到，所以写到父类中去
        HbaseCacheConfig cacheConfig = getCacheConfig(metaComConfig);

        int cacheInterval = ctx.getCommonQueryParam().getCacheInterval();

        if (cacheInterval < 0){
            cacheInterval = cacheConfig.getCacheInterval();
        }

        //若缓存间隔不为0，且缓存表中存在有效值，则从缓存读取
        if (cacheInterval > 0 ){

        }
    return null;
    }
}
