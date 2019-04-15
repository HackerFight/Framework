package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:11
 *
 * @desc
 */
public class DynamicComponentDependentDO {

    private String componentCode;
    /**
     * 组件依赖
     */
    private String componentCodeDependent;

    private String desc;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentCodeDependent() {
        return componentCodeDependent;
    }

    public void setComponentCodeDependent(String componentCodeDependent) {
        this.componentCodeDependent = componentCodeDependent;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
