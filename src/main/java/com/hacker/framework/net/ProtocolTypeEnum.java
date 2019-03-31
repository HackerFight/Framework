package com.hacker.framework.net;

/**
 * Created by Administrator on 2019/3/31 0031.
 */
public enum  ProtocolTypeEnum {

    HTTP_GET("GET"),

    HTTP_POST("POST"),
    ;

    String protocolType;

    ProtocolTypeEnum(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getProtocolType() {
        return protocolType;
    }
}
