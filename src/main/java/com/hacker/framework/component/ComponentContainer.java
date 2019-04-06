package com.hacker.framework.component;

import com.hacker.framework.service.CommonQueryResult;
import org.springframework.beans.factory.InitializingBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ComponentContainer implements InitializingBean {

    /**
     *  在XML 中进行初始化的
     */
    private Map<String, CommonComTemplate> commonComTemplateMap;

    private static Map<String, CommonComTemplate> staticTemplateMap = new ConcurrentHashMap<>(16);

    public static CommonComTemplate getComponent(String comTplType){
        return staticTemplateMap.get(comTplType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (Map.Entry<String, CommonComTemplate> entry : commonComTemplateMap.entrySet()) {
             putComponentTpl(entry.getKey(), entry.getValue());
        }
    }

    private void putComponentTpl(String comCode, CommonComTemplate commonComTemplate){
        staticTemplateMap.put(comCode, commonComTemplate);
    }

    public void setCommonComTemplateMap(Map<String, CommonComTemplate> commonComTemplateMap) {
        this.commonComTemplateMap = commonComTemplateMap;
    }

    public Map<String, CommonComTemplate> getCommonComTemplateMap() {
        return commonComTemplateMap;
    }

    public static Map<String, CommonComTemplate> getStaticTemplateMap() {
        return staticTemplateMap;
    }
}
