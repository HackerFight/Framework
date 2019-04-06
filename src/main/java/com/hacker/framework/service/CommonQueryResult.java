package com.hacker.framework.service;

import java.util.Map;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class CommonQueryResult {

    private boolean success;

    private String errorCode;

    private String errorMessage;

    private Map<String, String> resultMap;

    private boolean fromCache;
    /**
     * 数据加载时间戳：
     * 如果 fromCache=false,timeStamp 就是从外部返回的数据时间，如果外部返回的数据没有时间字段，就以系统取到的时间
     * 如果 fromCache=true, timeStamp 就是从cache获取的数据时间
     */
    private long timeStamp;

    public CommonQueryResult(boolean success, String errorCode, String errorMessage,
                             Map<String, String> resultMap, boolean fromCache){
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.resultMap = resultMap;
        this.fromCache = fromCache;
    }

    public CommonQueryResult buildErrorResult(String errorCode, String errorMessage){
        return new CommonQueryResult(false, errorCode, errorMessage, null, false);
    }

    public CommonQueryResult(){}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public boolean isFromCache() {
        return fromCache;
    }

    public void setFromCache(boolean fromCache) {
        this.fromCache = fromCache;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
