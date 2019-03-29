package com.hacker.framework.ex;

/**
 * Created by hacker on 2019/3/30 0030.
 *
 * 渠道异常
 */
public class ChannelException extends GdfException {

    public ChannelException(String channelCode, Throwable throwable, ErrorCode errorCode){
        super(channelCode+ " : " + errorCode.getCode(), throwable, errorCode);
    }
}
