package com.hacker.framework.context;

import com.hacker.framework.service.CommonQueryParam;
import com.hacker.framework.service.CommonQueryResult;

import java.util.Map;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class PipelineContext {

    private PipelineStatusEnum pipelineStatusEnum;

    private String dataviewCode;

    private Map<String, ChannelContext> channelContextMap;

    /**
     * 入参
     */
    private CommonQueryParam commonQueryParam;

    /**
     * 出参
     */
    private CommonQueryResult commonQueryResult;

    private Map<String, Object> runProperties;

    private long startTime;

    private long endTime;

    private Throwable throwable;
}
