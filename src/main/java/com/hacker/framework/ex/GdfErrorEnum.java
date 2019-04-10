package com.hacker.framework.ex;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public enum GdfErrorEnum implements ErrorCode{

    /*--------------------  业务异常 --------------------------*/
    ILLEGAL_BIZ_ARGUMENT("ILLEGAL_BIZ_ARGUMENT", "入参错误"),


    /*--------------------- 系统异常  ---------------------------*/
    SYS_EXCEPTION("SYS_EXCEPTION", "系统异常"),

    TELECOM_EXCEPTION("TELECOM_EXCEPTION", "通信异常"),

    CHANNEL_CONTEXT_EMPTY("CHANNEL_CONTEXT_EMPTY", "渠道上下文为空"),

    NO_SERVICE("NO_SERVICE", "无服务"),

    NO_SERVICE_AVAIABLE("NO_SERVICE", "服务不可用"),

    IO_EXCEPTION("IO_EXCEPTION","IO异常" ),

    CHANNEL_ORCHESTRATION_LOAD_ERROR("CHANNEL_ORCHESTRATION_LOAD_ERROR", "渠道编排错误" ),

    COMPONENT_ORCHESTRATION_LOAD_ERROR("COMPONENT_ORCHESTRATION_LOAD_ERROR", "组件编排错误" ),

    DATA_VIEW_LOAD_ERROR("DATA_VIEW_LOAD_ERROR", "试图加载错误"),

    DYNAMIC_COM_LOAD_ERROR("DYNAMIC_COM_LOAD_ERROR", "动态组件加载失败"),

    OTS_EXCEPTION("OTS_EXCEPTION", "OTS 异常");

    ;


    private String code;
    private String msg;

    GdfErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
