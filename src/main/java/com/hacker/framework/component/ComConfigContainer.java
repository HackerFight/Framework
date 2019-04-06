package com.hacker.framework.component;

import com.hacker.framework.constants.CacheItemConstants;
import com.hacker.framework.cache.CacheMap;
import com.hacker.framework.cache.enums.ExpireTypeEnum;
import com.hacker.framework.cache.loader.DataLoader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ComConfigContainer implements InitializingBean {

    @Autowired
    private DataLoader<String, MetaComConfig> metaComConfigDataLoader;
    @Autowired
    private CacheMap<String, MetaComConfig> metaComConfigCacheMap;

    public MetaComConfig getMetaComConfig(String comCode){
        return metaComConfigCacheMap.get(comCode);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        metaComConfigCacheMap = new CacheMap<String, MetaComConfig>(CacheItemConstants.META_COMPONENT_CONFIG,
                ExpireTypeEnum.REFRESH_AFTER_WRITE_AUTO_LOAD, metaComConfigDataLoader);
    }
}
