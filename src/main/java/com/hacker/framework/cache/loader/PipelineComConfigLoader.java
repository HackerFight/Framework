package com.hacker.framework.cache.loader;

import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.pipeline.Pipeline;
import com.hacker.framework.repository.ChannelOrchestrationRepository;
import com.hacker.framework.repository.ChannelRepository;
import com.hacker.framework.repository.ComponentOrchestrationRepository;
import com.hacker.framework.repository.DataviewRepository;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class PipelineComConfigLoader implements DataLoader<String, Pipeline> {

    private DataviewRepository dataviewRepository;
    private ChannelRepository channelRepository;
    private ChannelOrchestrationRepository channelOrchestrationRepository;
    private ComponentOrchestrationRepository componentOrchestrationRepository;

    @Override
    public Pipeline load(String key) {
        Pipeline pipeline = new Pipeline();
        Dataview dataview = dataviewRepository.getByPipelineCode(key);

        if (null == dataview){
            return null;
        }

        //将试图保存之链路中
        pipeline.setDataview(dataview);

        //查询渠道编排，就是试图和渠道的关系


        return null;
    }
}
