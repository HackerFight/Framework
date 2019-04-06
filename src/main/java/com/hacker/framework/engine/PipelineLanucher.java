package com.hacker.framework.engine;

import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.pipeline.Pipeline;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public interface PipelineLanucher {

    Pipeline lanuchDataview(Dataview dataview, PipelineContext pipelineContext);

    Pipeline lanuchChannel(Channel channel, PipelineContext pipelineContext);
}
