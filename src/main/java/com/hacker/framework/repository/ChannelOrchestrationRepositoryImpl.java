package com.hacker.framework.repository;

import com.hacker.framework.repository.dao.ChannelOrchestrationDAO;
import com.hacker.framework.repository.weave.ChannelOrchestration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ChannelOrchestrationRepositoryImpl implements ChannelOrchestrationRepository {

    @Autowired
    private ChannelOrchestrationDAO channelOrchestrationDAO;

    @Override
    public List<ChannelOrchestration> getListByPipelineCode(String pipelineCode) {
        return null;
    }

    @Override
    public List<ChannelOrchestration> getListByCode(String channelCode) {
        return null;
    }
}
