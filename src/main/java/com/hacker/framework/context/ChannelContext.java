package com.hacker.framework.context;

import com.hacker.framework.net.NetRequest;
import com.hacker.framework.net.NetResponse;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class ChannelContext {

    private ChannelStatusEnum channelStatusEnum;

    private String statusMsg;

    private String channelCode;

    private NetRequest netRequest;

    private NetResponse netResponse;

    private boolean enableRemoteInvoke = false;

    private long startTime;

    private long endTime;

    public ChannelStatusEnum getChannelStatusEnum() {
        return channelStatusEnum;
    }

    public void setChannelStatusEnum(ChannelStatusEnum channelStatusEnum) {
        this.channelStatusEnum = channelStatusEnum;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public NetRequest getNetRequest() {
        return netRequest;
    }

    public void setNetRequest(NetRequest netRequest) {
        this.netRequest = netRequest;
    }

    public NetResponse getNetResponse() {
        return netResponse;
    }

    public void setNetResponse(NetResponse netResponse) {
        this.netResponse = netResponse;
    }

    public boolean isEnableRemoteInvoke() {
        return enableRemoteInvoke;
    }

    public void setEnableRemoteInvoke(boolean enableRemoteInvoke) {
        this.enableRemoteInvoke = enableRemoteInvoke;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
