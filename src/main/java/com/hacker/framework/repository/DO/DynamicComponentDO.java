package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DynamicComponentDO {

    private String componentCode;

    private String dynamicComponentType;

    private String componentDesc;

    private Integer prod;

    private Integer preTest;

    private Integer prePercent;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getDynamicComponentType() {
        return dynamicComponentType;
    }

    public void setDynamicComponentType(String dynamicComponentType) {
        this.dynamicComponentType = dynamicComponentType;
    }

    public String getComponentDesc() {
        return componentDesc;
    }

    public void setComponentDesc(String componentDesc) {
        this.componentDesc = componentDesc;
    }

    public Integer getProd() {
        return prod;
    }

    public void setProd(Integer prod) {
        this.prod = prod;
    }

    public Integer getPreTest() {
        return preTest;
    }

    public void setPreTest(Integer preTest) {
        this.preTest = preTest;
    }

    public Integer getPrePercent() {
        return prePercent;
    }

    public void setPrePercent(Integer prePercent) {
        this.prePercent = prePercent;
    }
}
