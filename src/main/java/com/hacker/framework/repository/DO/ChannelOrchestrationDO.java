package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ChannelOrchestrationDO extends BaseDO{

    private String channelCode;

    private Integer channelOrder;

    private String dataviewCode;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Integer getChannelOrder() {
        return channelOrder;
    }

    public void setChannelOrder(Integer channelOrder) {
        this.channelOrder = channelOrder;
    }

    public String getDataviewCode() {
        return dataviewCode;
    }

    public void setDataviewCode(String dataviewCode) {
        this.dataviewCode = dataviewCode;
    }
}
