package com.hacker.framework.component.executor;

import com.hacker.framework.component.CommonComTemplate;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.engine.PipelineAssember;
import com.hacker.framework.engine.PipelineLanucher;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.pipeline.Pipeline;
import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/4/6 0006.
 */
public class DefaultDispatchComTpl extends CommonComTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDispatchComTpl.class);

    @Autowired
    private PipelineLanucher standardPipelineLanucher;

    @Autowired
    private PipelineAssember standardPipelineAssember;

    @Override
    public Object doRun(MetaComConfig metaComConfig, PipelineContext ctx) {
        Pipeline pipeline = standardPipelineAssember.assemble(ctx.getDataviewCode());
        Channel channel = null;
        if (pipeline.getChannelGroup().getChannelList().size() == 1){
            channel = pipeline.getChannelGroup().getChannelList().get(0);
        }

        if (null == channel){
            String errMsg = pipeline.getDataview().getDataviewCode() + ":" + GdfErrorEnum.CHANNEL_ORCHESTRATION_LOAD_ERROR.getMsg();
            LoggerUtil.error(LOGGER, errMsg);
            throw new GdfException(errMsg, GdfErrorEnum.CHANNEL_ORCHESTRATION_LOAD_ERROR);
        }

        standardPipelineLanucher.lanuchChannel(channel, ctx);

        return null;
    }
}


