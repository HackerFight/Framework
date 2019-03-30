package com.hacker.framework.pipeline;

import java.util.List;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class Dataview {

    /**
     * 试图编码
     */
    private String dataviewCode;

    /**
     * 请求组建的集合，比如缓存读
     */
    private List<String> requestComList;

    /**
     * 响应组件的集合，比如缓存写
     */
    private List<String> responseComList;

    /**
     * 连接渠道的组件标识
     */
    private String channelDispatchCom;

    private boolean available;

    public String getDataviewCode() {
        return dataviewCode;
    }

    public void setDataviewCode(String dataviewCode) {
        this.dataviewCode = dataviewCode;
    }

    public List<String> getRequestComList() {
        return requestComList;
    }

    public void setRequestComList(List<String> requestComList) {
        this.requestComList = requestComList;
    }

    public List<String> getResponseComList() {
        return responseComList;
    }

    public void setResponseComList(List<String> responseComList) {
        this.responseComList = responseComList;
    }

    public String getChannelDispatchCom() {
        return channelDispatchCom;
    }

    public void setChannelDispatchCom(String channelDispatchCom) {
        this.channelDispatchCom = channelDispatchCom;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
