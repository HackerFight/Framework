package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ChannelOrchestrationDO;
import com.hacker.framework.repository.weave.ChannelOrchestration;

import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ChannelOrchestrationDAO {

    List<ChannelOrchestrationDO> getOrchestrationsByChannelCode(String channelCode);

    List<ChannelOrchestrationDO> getOrchestrationsByDataviewCode(String pipelineCode);
}
