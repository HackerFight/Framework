package com.hacker.framework.net;

import org.apache.http.HttpEntity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/30 0030.
 */
public class NetRequest {

    private String url;

    private ProtocolTypeEnum protocolTypeEnum;

    /**
     * 直接new好
     */
    private Map<String, String> urlParam = new LinkedHashMap<>(8);

    private Map<String, String> headers = new LinkedHashMap<>(8);

    private HttpEntity httpEntity;

    private int connReqTimeout = 500;

    private int connTimeout = 1000;

    private int socketTimeout = 2500;

    /**
     * 添加请求头
     * @param key
     * @param value
     */
    public void addHeader(String key, String value){
        this.headers.put(key, value);
    }

    /**
     * 添加请求参数
     * @param key
     * @param value
     */
    public void addUrlParam(String key, String value){
        this.urlParam.put(key, value);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProtocolTypeEnum getProtocolTypeEnum() {
        return protocolTypeEnum;
    }

    public void setProtocolTypeEnum(ProtocolTypeEnum protocolTypeEnum) {
        this.protocolTypeEnum = protocolTypeEnum;
    }

    public Map<String, String> getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(Map<String, String> urlParam) {
        this.urlParam = urlParam;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public void setHttpEntity(HttpEntity httpEntity) {
        this.httpEntity = httpEntity;
    }

    public int getConnReqTimeout() {
        return connReqTimeout;
    }

    public void setConnReqTimeout(int connReqTimeout) {
        this.connReqTimeout = connReqTimeout;
    }

    public int getConnTimeout() {
        return connTimeout;
    }

    public void setConnTimeout(int connTimeout) {
        this.connTimeout = connTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
