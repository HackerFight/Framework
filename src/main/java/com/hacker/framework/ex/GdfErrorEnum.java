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
