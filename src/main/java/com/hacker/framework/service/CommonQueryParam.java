package com.hacker.framework.service;

import java.util.Map;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class CommonQueryParam {

    /**
     * 请求时的参数都封装到这个对象中
     */
    private Map<String, String> queryConditions;

    public Map<String, String> getQueryConditions() {
        return queryConditions;
    }

    public void setQueryConditions(Map<String, String> queryConditions) {
        this.queryConditions = queryConditions;
    }
}
