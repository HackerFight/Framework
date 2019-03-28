package com.hacker.framework.cache.enums;

/**
 * Created by hacker on 2019/3/27 0027.
 */
public enum CacheTypeEnum {

    LOCAL("LOCAL", "JVM缓存"),

    TAIR("TAIR", "tair缓存"),
        ;
    private String code;

    private String desc;

    CacheTypeEnum(String code, String desc){
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
