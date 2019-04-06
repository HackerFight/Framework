package com.hacker.framework.enums;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public enum ComponentDirectionEnum {
    /**
     * 请求路径
     */
    REQUEST("request", "请求路径"),
    /**
     * 请求路径
     */
    RESPONSE("response", "响应路径"),
    /**
     * 调度节点
     */
    DISPATCH("dispatch", "调度节点"),
    /**
     * 调度节点
     */
    TELCOM("telcom", "通信节点"),
    ;

    private String code;

    private String desc;

    ComponentDirectionEnum(String code, String desc ){
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }
}
