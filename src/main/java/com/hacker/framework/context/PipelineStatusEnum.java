package com.hacker.framework.context;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public enum PipelineStatusEnum {

    RUNNING("RUNNING"),

    SUCCESS("SUCCESS"),

    FAIL("FAIL"),
    ;

    private String status;

    PipelineStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
