package com.hacker.framework.enums;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public enum  ComTplTypeEnum {

    DYNAMIC("dynamic"),

    CACHE_WRITE("cache_write"),

    CACHE_READ("cache_read"),

    NET_TELCOM("net_telcom"),

    DEFAULT_DISPATCH("default_dispatch"),
    ;

    private String type;

    ComTplTypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
