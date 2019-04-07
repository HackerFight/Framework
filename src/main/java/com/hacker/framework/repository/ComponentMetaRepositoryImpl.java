package com.hacker.framework.repository;

import com.hacker.framework.component.DynamicComConfig;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.repository.DO.ComponentMetaDO;
import com.hacker.framework.repository.DO.ComponentOrchestrationDO;
import com.hacker.framework.repository.DO.DynamicComponentDO;
import com.hacker.framework.repository.DO.DynamicComponentScriptDO;
import com.hacker.framework.repository.dao.ComponentMetaDAO;
import com.hacker.framework.repository.dao.ComponentOrchestrationDAO;
import com.hacker.framework.repository.dao.DynamicComponentDAO;
import com.hacker.framework.repository.dao.DynamicComponentScriptDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public class ComponentMetaRepositoryImpl implements ComponentMetaRepository {

    @Autowired
    private ComponentMetaDAO componentMetaDAO;
    @Autowired
    private DynamicComponentDAO dynamicComponentDAO;
    @Autowired
    private DynamicComponentScriptDAO dynamicComponentScriptDAO;
    @Autowired
    private ComponentOrchestrationDAO componentOrchestrationDAO;


    @Override
    public DynamicComConfig getDynamicComByCode(String componentCode) {
        DynamicComConfig dynamicComConfig = new DynamicComConfig();
        DynamicComponentDO dynamicComponentDO = dynamicComponentDAO.getByCode(componentCode);
        if (null != dynamicComponentDO){
            dynamicComConfig.setPrePercent(dynamicComponentDO.getPrePercent());
        }

        DynamicComponentScriptDO preScriptDO = dynamicComponentScriptDAO.getByCodeAndVersion(
                componentCode, dynamicComponentDO.getPreTest());
        if (null != preScriptDO){
            dynamicComConfig.setPreScript(preScriptDO.getGroovyScript());
        }

        DynamicComponentScriptDO prodScriptDO = dynamicComponentScriptDAO.getByCodeAndVersion(
                componentCode, dynamicComponentDO.getProd());
        if (null != prodScriptDO){
            dynamicComConfig.setProdScript(prodScriptDO.getGroovyScript());
        }

        return dynamicComConfig;
    }

    @Override
    public MetaComConfig getMetaComByCode(String componentCode) {
        ComponentMetaDO componentMetaDO = componentMetaDAO.getByCode(componentCode);
        if (null == componentCode){
            return null;
        }

        MetaComConfig metaComConfig = domaintoFunction.apply(componentMetaDO);
        ComponentOrchestrationDO componentOrchestrationDO = componentOrchestrationDAO.getOrchestrationByComponentCode(
                componentCode);
        if (null != componentOrchestrationDO){
            //这个就是视图或渠道的类型：视图-dataview    渠道-channel
            metaComConfig.setModelType(componentOrchestrationDO.getRelType());
            //这个就是试图或渠道的编码：试图-dataview   渠道-channel
            metaComConfig.setModelCode(componentOrchestrationDO.getRelCode());
        }

        return metaComConfig;
    }

    private static Function<ComponentMetaDO, MetaComConfig> domaintoFunction = componentMetaDO -> {
        MetaComConfig metaComConfig = new MetaComConfig();
        metaComConfig.setComponentCode(componentMetaDO.getComponentCode());
        //组件类型： dynamic, cache_read cache_write comtel ...
        metaComConfig.setComTplType(componentMetaDO.getComponentType());
        metaComConfig.setConfig(componentMetaDO.getConfigParam());
        return metaComConfig;
    };
}
