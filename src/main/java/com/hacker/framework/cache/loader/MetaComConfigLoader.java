package com.hacker.framework.cache.loader;

import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.repository.ComponentMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public class MetaComConfigLoader implements  DataLoader<String, MetaComConfig>{

    @Autowired
    private ComponentMetaRepository componentMetaRepository;

    @Override
    public MetaComConfig load(String key) {
        //todo....
        MetaComConfig metaComByCode = componentMetaRepository.getMetaComByCode(key);
        return metaComByCode;
    }
}
