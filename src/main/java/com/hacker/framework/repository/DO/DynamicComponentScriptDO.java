package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DynamicComponentScriptDO {

    private String componentCode;

    private String groovyScript;

    private Integer version;

    private String desc;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getGroovyScript() {
        return groovyScript;
    }

    public void setGroovyScript(String groovyScript) {
        this.groovyScript = groovyScript;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
