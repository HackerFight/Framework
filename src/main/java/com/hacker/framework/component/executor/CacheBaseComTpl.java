package com.hacker.framework.component.executor;

import com.hacker.framework.component.CommonComTemplate;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.hbase.ColumnBaseStorageService;
import com.hacker.framework.hbase.HbaseCacheConfig;
import com.hacker.framework.repository.dao.DataMetaConfigDAO;
import com.hacker.framework.repository.dao.DataTemplateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.HandlerBase;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public abstract class CacheBaseComTpl extends CommonComTemplate {

    @Autowired
    private DataTemplateDAO dataTemplateDAO;

    @Autowired
    private DataMetaConfigDAO dataMetaConfigDAO;

    //这个属性是 protected 的
    @Autowired
    protected ColumnBaseStorageService columnBaseStorageService;

    /**
     * 这个做缓存的的基类，可以做一些加载配置使用，比如缓存读写都用到的配置
     *
     * 做成 protected 方法
     */

    protected HbaseCacheConfig getCacheConfig(MetaComConfig metaComConfig){
        /**
         * 做一些数据库的查询操作....
         */
        return new HbaseCacheConfig();
   }

}
