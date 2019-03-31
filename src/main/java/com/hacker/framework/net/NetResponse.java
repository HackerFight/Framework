package com.hacker.framework.net;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class NetResponse {

    /**
     * 状态吗
     */
    private int statusCode;

    /**
     * 响应报文
     */
    private String entryMessage;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getEntryMessage() {
        return entryMessage;
    }

    public void setEntryMessage(String entryMessage) {
        this.entryMessage = entryMessage;
    }
}
