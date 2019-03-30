package com.hacker.framework.context;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public enum ChannelStatusEnum {

    SUCCESS("SUCCESS"),

    RUNNING("RUNNING"),

    FAIL("FAIL"),
    ;

    private String status;

    ChannelStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
