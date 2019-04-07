package com.hacker.framework.engine;

import com.hacker.framework.component.ComponentRunner;
import com.hacker.framework.context.ChannelContext;
import com.hacker.framework.context.ChannelStatusEnum;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.ex.ChannelException;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.pipeline.Pipeline;
import com.hacker.framework.service.CommonQueryResult;
import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class StandardPipelineLanucher implements PipelineLanucher {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandardPipelineLanucher.class);

    //要创建组件运行器才行，但是如何在预先就构建蓝图，知道应该先创建哪一个类呢？
    private ComponentRunner standardComponentRunner;

    private ComponentRunner logDataviewComponentRunner;

    private ComponentRunner logChannelComponentRunner;

    /**
     * 加载试图
     * @param dataview
     * @param pipelineContext
     * @return
     */
    @Override
    public void lanuchDataview(Dataview dataview, PipelineContext pipelineContext) {
        Map<String, ChannelContext> channelContextMap = new HashMap<>();
        pipelineContext.setChannelContextMap(channelContextMap);
        pipelineContext.setStartTime(System.currentTimeMillis());

        List<String> requestComList = dataview.getRequestComList();
        List<String> responseComList = dataview.getResponseComList();

        try {
            //执行请求组建，比如缓存读，动态请求脚本等
            for (String comCode : requestComList) {
                standardComponentRunner.runComponent(comCode, pipelineContext);
            }

            //试图和渠道的连接点
            standardComponentRunner.runComponent(dataview.getChannelDispatchCom(), pipelineContext);

            for (String comCode : responseComList) {
                 standardComponentRunner.runComponent(comCode, pipelineContext);
            }
        } catch (Exception e) {
            pipelineContext.completeAndFail(e);
            LoggerUtil.error(LOGGER, e);
            CommonQueryResult commonQueryResult = new CommonQueryResult();
            commonQueryResult.setSuccess(false);
            if (e instanceof GdfException){
                commonQueryResult.setErrorCode(((GdfException) e).getCode());
                commonQueryResult.setErrorMessage(((GdfException) e).getMessage());
            }else{
                commonQueryResult.setErrorMessage(GdfErrorEnum.SYS_EXCEPTION.getCode());
                commonQueryResult.setErrorMessage(GdfErrorEnum.SYS_EXCEPTION.getMsg());
            }
            pipelineContext.completeAndFail(commonQueryResult);
        }finally {
            pipelineContext.setEndTime(System.currentTimeMillis());
            if (!pipelineContext.getCommonQueryResult().isFromCache()){
                pipelineContext.getCommonQueryResult().setTimeStamp(pipelineContext.getEndTime());
            }
            logDataviewComponentRunner.runComponent(dataview.getDataviewCode(), pipelineContext);
        }

    }

    /**
     * 加载渠道
     * @param channel
     * @param pipelineContext
     * @return
     */
    @Override
    public void lanuchChannel(Channel channel, PipelineContext pipelineContext) {
        ChannelContext channelContext = new ChannelContext(channel.getChannelCode());
        channelContext.setStartTime(System.currentTimeMillis());
        channelContext.setChannelStatusEnum(ChannelStatusEnum.RUNNING);

        pipelineContext.setChannelContext(channel.getChannelCode(), channelContext);

        List<String> requestComList = channel.getRequestComList();
        List<String> responseComList = channel.getResponseComList();

        try {
            //循环执行渠道的每一个请求组件，不如token缓存读，动态请求脚本...
            for (String comCode : requestComList) {
                 standardComponentRunner.runComponent(comCode, pipelineContext);
            }

            //执行网络请求
            standardComponentRunner.runComponent(channel.getNetTelCom(), pipelineContext);

            for (String comCode : responseComList) {
                standardComponentRunner.runComponent(comCode, pipelineContext);
            }
        } catch (Exception e) {
            channelContext.errorChannel(e);
            throw new ChannelException(channel.getChannelCode(), e, GdfErrorEnum.SYS_EXCEPTION);
        } finally {

            channelContext.setEndTime(System.currentTimeMillis());
            logChannelComponentRunner.runComponent(channel.getChannelCode(), pipelineContext);
        }

    }
}
