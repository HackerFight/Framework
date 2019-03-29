package com.hacker.framework.ex;

/**
 * Created by Administrator on 2019/3/30 0030.
 */
public class GdfException extends RuntimeException {

    private ErrorCode errorCode;

    public GdfException(Throwable throwable, ErrorCode errorCode){
        super(errorCode.getMsg(), throwable);
        this.errorCode = errorCode;
    }

    public GdfException(String errMsg, Throwable throwable, ErrorCode errorCode){
        super(errMsg, throwable);
        this.errorCode = errorCode;
    }

    public GdfException(String errMsg, ErrorCode errorCode){
        super(errMsg, null);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode(){
        return errorCode;
    }

    /**
     *  调用 ErrorCode 的方法用于返回
     * @return
     */
    public String getCode(){
        return errorCode.getCode();
    }

    public String getMsg(){
        return errorCode.getMsg();
    }
}
