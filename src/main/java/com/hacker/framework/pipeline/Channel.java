package com.hacker.framework.pipeline;

import java.util.List;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class Channel {

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 请求组件，比如 request 脚本
     */
    private List<String> requestComList;

    /**
     * 通信组建
     */
    private String netTelCom;

    /**
     * 响应组件，比如 response 脚本
     */
    private List<String> responseComList;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public List<String> getRequestComList() {
        return requestComList;
    }

    public void setRequestComList(List<String> requestComList) {
        this.requestComList = requestComList;
    }

    public String getNetTelCom() {
        return netTelCom;
    }

    public void setNetTelCom(String netTelCom) {
        this.netTelCom = netTelCom;
    }

    public List<String> getResponseComList() {
        return responseComList;
    }

    public void setResponseComList(List<String> responseComList) {
        this.responseComList = responseComList;
    }
}
