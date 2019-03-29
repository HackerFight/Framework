package com.hacker.framework.ex;

/**
 * Created by hacker on 2019/3/30 0030.
 *
 * 组件异常
 */
public class ComException extends GdfException{

    public ComException(String comCode, Throwable throwable, GdfErrorEnum gdfErrorEnum){
        super(comCode + " : " +  gdfErrorEnum.getCode(), throwable, gdfErrorEnum);
    }


    public ComException(String comCode, GdfErrorEnum gdfErrorEnum){
        super(comCode + " : " + gdfErrorEnum.getCode() , gdfErrorEnum);
    }
}
