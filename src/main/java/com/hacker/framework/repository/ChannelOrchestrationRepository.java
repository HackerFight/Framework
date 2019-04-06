package com.hacker.framework.repository;

import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.repository.weave.ChannelOrchestration;

import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ChannelOrchestrationRepository {

    /**
     * 通过链路编码（就是试图编码）来查询渠道编排
     * @param pipelineCode
     * @return
     */
    List<ChannelOrchestration> getListByPipelineCode(String pipelineCode);


    List<ChannelOrchestration> getListByCode(String channelCode);
}
