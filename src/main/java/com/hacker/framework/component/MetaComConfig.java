package com.hacker.framework.component;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class MetaComConfig {

    private String componentCode;

    private String comTplType;

    private String modelType;

    private String modelCode;

    private Object config;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComTplType() {
        return comTplType;
    }

    public void setComTplType(String comTplType) {
        this.comTplType = comTplType;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Object getConfig() {
        return config;
    }

    public void setConfig(Object config) {
        this.config = config;
    }
}
