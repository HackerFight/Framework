package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ChannelOrchestrationDO;
import com.hacker.framework.repository.weave.ChannelOrchestration;

import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ChannelOrchestrationDAO {

    /**
     *  通过渠道编码查询渠道编排信息
     * @param channelCode
     * @return
     */
    List<ChannelOrchestrationDO> getOrchestrationsByChannelCode(String channelCode);

    /**
     *  通过链路编码（视图码）查询渠道编排
     * @param pipelineCode
     * @return
     */
    List<ChannelOrchestrationDO> getOrchestrationsByDataviewCode(String pipelineCode);
}
