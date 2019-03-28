package com.hacker.framework.cache.enums;

/**
 * Created by hacker on 2019/3/27 0027.
 */
public enum ExpireTypeEnum {

    EXPIRE_AFTER_WRITE("EXPIRE_AFTER_WRITE", "写超时置空,返回null"),

    EXPIRE_AFTER_WRITE_AUTO_LOAD("EXPIRE_AFTER_WRITE_AUTO_LOAD", "写超时后单线程阻塞重新load数据"),

    REFRESH_AFTER_WRITE_AUTO_LOAD("REFRESH_AFTER_WRITE_AUTO_LOAD", "写超时后异步单线程重新load数据，在load完成之前所有访问该key的线程仍然返回老数据"),

        ;
    private String code;

    private String desc;

    ExpireTypeEnum(String code, String desc){
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
