package com.hacker.framework.engine;

import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class StandardPipelineLanucher implements PipelineLanucher {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandardPipelineLanucher.class);

    //要创建组件运行器才行，但是如何在预先就构建蓝图，知道应该先创建哪一个类呢？

    /**
     * 加载试图
     * @param dataview
     * @param pipelineContext
     * @return
     */
    @Override
    public Pipeline lanuchDataview(Dataview dataview, PipelineContext pipelineContext) {
        return null;
    }

    /**
     * 加载渠道
     * @param channel
     * @param pipelineContext
     * @return
     */
    @Override
    public Pipeline lanuchChannel(Channel channel, PipelineContext pipelineContext) {
        return null;
    }
}
