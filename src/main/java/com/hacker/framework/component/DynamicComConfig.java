package com.hacker.framework.component;

import groovy.lang.GroovyObject;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DynamicComConfig {

    private GroovyObject preGroovy;

    private GroovyObject prodGroovy;

    private String preScript;

    private String prodScript;

    private int prePercent;

    public GroovyObject getPreGroovy() {
        return preGroovy;
    }

    public void setPreGroovy(GroovyObject preGroovy) {
        this.preGroovy = preGroovy;
    }

    public GroovyObject getProdGroovy() {
        return prodGroovy;
    }

    public void setProdGroovy(GroovyObject prodGroovy) {
        this.prodGroovy = prodGroovy;
    }

    public String getPreScript() {
        return preScript;
    }

    public void setPreScript(String preScript) {
        this.preScript = preScript;
    }

    public String getProdScript() {
        return prodScript;
    }

    public void setProdScript(String prodScript) {
        this.prodScript = prodScript;
    }

    public int getPrePercent() {
        return prePercent;
    }

    public void setPrePercent(int prePercent) {
        this.prePercent = prePercent;
    }
}
