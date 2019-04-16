package com.hacker.framework.service;

import java.util.Map;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class CommonQueryParam {

    private String bizNo;

    private String visitBiz;

    private String visitBizLine;

    private String visitDomain;

    private String serviceName;

    /**
     * 请求时的参数都封装到这个对象中
     */
    private Map<String, String> queryConditions;

    private int cacheInterval = -1;

    public int getCacheInterval() {
        return cacheInterval;
    }

    public void setCacheInterval(int cacheInterval) {
        this.cacheInterval = cacheInterval;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getVisitBiz() {
        return visitBiz;
    }

    public void setVisitBiz(String visitBiz) {
        this.visitBiz = visitBiz;
    }

    public String getVisitBizLine() {
        return visitBizLine;
    }

    public void setVisitBizLine(String visitBizLine) {
        this.visitBizLine = visitBizLine;
    }

    public String getVisitDomain() {
        return visitDomain;
    }

    public void setVisitDomain(String visitDomain) {
        this.visitDomain = visitDomain;
    }

    public Map<String, String> getQueryConditions() {
        return queryConditions;
    }

    public void setQueryConditions(Map<String, String> queryConditions) {
        this.queryConditions = queryConditions;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
