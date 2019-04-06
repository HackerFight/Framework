package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ComponentMetaDO {

    //todo... 这个DO 对应哪个数据表呢？
    private String componentCode;

    private String componentType;

    private String configParam;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getConfigParam() {
        return configParam;
    }

    public void setConfigParam(String configParam) {
        this.configParam = configParam;
    }
}
