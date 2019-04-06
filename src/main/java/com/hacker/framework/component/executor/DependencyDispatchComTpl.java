package com.hacker.framework.component.executor;

import com.hacker.framework.component.CommonComTemplate;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.ChannelContext;
import com.hacker.framework.context.ChannelStatusEnum;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.engine.PipelineAssember;
import com.hacker.framework.engine.PipelineLanucher;
import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.pipeline.Pipeline;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DependencyDispatchComTpl extends CommonComTemplate {

    private PipelineLanucher standardPipelineLanucher;

    private PipelineAssember standardPipelineAssember;

    @Override
    public Object doRun(MetaComConfig metaComConfig, PipelineContext ctx) {

        Pipeline pipeline = standardPipelineAssember.assemble(ctx.getDataviewCode());
        for (Channel channel : pipeline.getChannelGroup().getChannelList()) {

            standardPipelineLanucher.lanuchChannel(channel, ctx);
            ChannelContext channelContext = ctx.getChannelContext(channel.getChannelCode());
            if (ChannelStatusEnum.SUCCESS != channelContext.getChannelStatusEnum()){
                //渠道执行失败，不进行后续调用
                break;
            }
        }
        return null;
    }

    /**
     * 可以使用 @Autowried 装配，也可以使用 set方法进行装配
     * @param standardPipelineAssember
     */
    public void setStandardPipelineAssember(PipelineAssember standardPipelineAssember) {
        this.standardPipelineAssember = standardPipelineAssember;
    }

    public void setStandardPipelineLanucher(PipelineLanucher standardPipelineLanucher) {
        this.standardPipelineLanucher = standardPipelineLanucher;
    }
}