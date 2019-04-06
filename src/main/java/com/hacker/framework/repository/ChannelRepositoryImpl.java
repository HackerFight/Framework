package com.hacker.framework.repository;

import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.repository.dao.ChannelDAO;
import com.hacker.framework.repository.weave.ChannelOrchestration;

import java.util.List;
import java.util.Map;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ChannelRepositoryImpl implements ChannelRepository {

    private ChannelDAO channelDAO;

    @Override
    public Channel getByCode(String channelCode) {
        return null;
    }

    @Override
    public List<Channel> getChannelsByOrchestration(List<ChannelOrchestration> channelOrchestrations) {
        return null;
    }

    @Override
    public Map<String, ChannelOrchestration> getMapByOrchestration(List<ChannelOrchestration> channelOrchestrations) {
        return null;
    }
}
