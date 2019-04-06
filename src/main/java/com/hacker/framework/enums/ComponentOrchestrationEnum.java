package com.hacker.framework.enums;

/**
 * Created by Administrator on 2019/4/6 0006.
 */
public enum ComponentOrchestrationEnum {

    DATAVIEW("dataview", "试图"),

    CHANNEL("channel", "渠道"),
    ;

    private String code;

    private String desc;

    ComponentOrchestrationEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
