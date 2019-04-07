package com.hacker.framework.cache.loader;

import com.hacker.framework.component.DynamicComConfig;
import com.hacker.framework.ex.ComException;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import com.hacker.framework.groovy.GroovyService;
import com.hacker.framework.repository.ComponentMetaRepository;
import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2019/4/7 0007.
 */
public class DynamicComConfigLoader implements DataLoader<String, DynamicComConfig>{

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicComConfigLoader.class);

    @Autowired
    private GroovyService groovyService;

    @Autowired
    private ComponentMetaRepository componentMetaRepository;

    @Override
    public DynamicComConfig load(String key) {
        DynamicComConfig dynamicComConfig = componentMetaRepository.getDynamicComByCode(key);

        try {
            dynamicComConfig.setPreGroovy(groovyService.compileScript(dynamicComConfig.getPreScript()));
            dynamicComConfig.setProdGroovy(groovyService.compileScript(dynamicComConfig.getProdScript()));
        } catch (Exception e) {
            LoggerUtil.error(LOGGER, MessageFormat.format("组件[{0}] 加载失败，请检查", key));
            throw new ComException(key, e, GdfErrorEnum.DYNAMIC_COM_LOAD_ERROR);
        }
        LoggerUtil.info(LOGGER, MessageFormat.format("组件[{0}]加载成功", key));

        return dynamicComConfig;
    }
}
