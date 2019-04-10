package com.hacker.framework.hbase;

import com.aliyun.openservices.ots.OTSClient;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public class OtsAdapterBuilder {

    @Value("${ots.endpoint}")
    private String endpoint;

    @Value("${ots.accessKey}")
    private String accessKey;

    @Value("${ots.accessSecret}")
    private String accessSecret;

    @Value("${ots.instanceId}")
    private String instanceId;

    public OTSClient build(){
        return new OTSClient(endpoint, accessKey, accessSecret);
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
