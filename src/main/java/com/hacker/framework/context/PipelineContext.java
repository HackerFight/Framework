package com.hacker.framework.context;

import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import com.hacker.framework.service.CommonQueryParam;
import com.hacker.framework.service.CommonQueryResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class PipelineContext {

    /**
     * 链路的执行状态- RUNNING-SUCCESS-FAIL
     */
    private PipelineStatusEnum pipelineStatusEnum;

    /**
     * 试图编码（渠道上下文中包含了渠道的编码）
     */
    private String dataviewCode;

    /**
     * 渠道上下文
     */
    private Map<String, ChannelContext> channelContextMap;

    /**
     * 入参
     */
    private CommonQueryParam commonQueryParam;

    /**
     * 出参
     */
    private CommonQueryResult commonQueryResult;

    /**
     * 运行时属性值
     */
    private Map<String, Object> runProperties;

    private long startTime;

    private long endTime;

    private Throwable throwable;

    public boolean isComplete(){
        return this.pipelineStatusEnum == PipelineStatusEnum.SUCCESS
                || this.pipelineStatusEnum == PipelineStatusEnum.FAIL;
    }

    //链路执行完成-失败
    public void completeAndFail(Throwable throwable){
        this.pipelineStatusEnum = PipelineStatusEnum.FAIL;
        this.throwable = throwable;
    }

    //链路执行完成-失败
    public void completeAndFail(CommonQueryResult commonQueryResult){
        this.pipelineStatusEnum = PipelineStatusEnum.FAIL;
        this.commonQueryResult = commonQueryResult;
    }

    //链路执行完成-成功
    public void completeAndSuc(CommonQueryResult commonQueryResult){
        this.pipelineStatusEnum = PipelineStatusEnum.SUCCESS;
        this.commonQueryResult = commonQueryResult;
    }

    /**
     * 获取渠道上下文
     * @param channelCode
     * @return
     */
    public ChannelContext getChannelContext(String channelCode){
        ChannelContext channelContext = channelContextMap.get(channelCode);
        if (null == channelContext){
            throw new GdfException(channelCode, GdfErrorEnum.CHANNEL_CONTEXT_EMPTY);
        }
        return channelContext;
    }

    /**
     * 设置渠道上下文
     * @param channelCode
     * @param channelContext
     */
    public void setChannelContext(String channelCode, ChannelContext channelContext){
        this.channelContextMap.put(channelCode, channelContext);
    }

    /**
     * 添加运行时属性
     * @param propKey
     * @param propValue
     */
    public void addRunProperties(String propKey, String propValue){
        if (null == this.runProperties){
            this.runProperties = new HashMap<>(16);
        }
        this.runProperties.put(propKey, propValue);
    }

    /**
     * 获取运行时属性值
     * @param propKey
     * @return
     */
    public Object getRunProperty(String propKey){
        if (null == this.runProperties){
            return null;
        }
        return this.runProperties.get(propKey);
    }

    /**
     * 获取请求参数
     * @return
     */
    public Map<String, String> getQueryConditions(){
        return commonQueryParam.getQueryConditions();
    }


    public PipelineStatusEnum getPipelineStatusEnum() {
        return pipelineStatusEnum;
    }

    public void setPipelineStatusEnum(PipelineStatusEnum pipelineStatusEnum) {
        this.pipelineStatusEnum = pipelineStatusEnum;
    }

    public String getDataviewCode() {
        return dataviewCode;
    }

    public void setDataviewCode(String dataviewCode) {
        this.dataviewCode = dataviewCode;
    }

    public Map<String, ChannelContext> getChannelContextMap() {
        return channelContextMap;
    }

    public void setChannelContextMap(Map<String, ChannelContext> channelContextMap) {
        this.channelContextMap = channelContextMap;
    }

    public CommonQueryParam getCommonQueryParam() {
        return commonQueryParam;
    }

    public void setCommonQueryParam(CommonQueryParam commonQueryParam) {
        this.commonQueryParam = commonQueryParam;
    }

    public CommonQueryResult getCommonQueryResult() {
        return commonQueryResult;
    }

    public void setCommonQueryResult(CommonQueryResult commonQueryResult) {
        this.commonQueryResult = commonQueryResult;
    }

    public Map<String, Object> getRunProperties() {
        return runProperties;
    }

    public void setRunProperties(Map<String, Object> runProperties) {
        this.runProperties = runProperties;
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

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
