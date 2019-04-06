package com.hacker.framework.repository;

import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.repository.weave.ChannelOrchestration;

import java.util.List;
import java.util.Map;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ChannelRepository {

    /**
     * 通过渠道编码查询渠道
     * @param channelCode
     * @return
     */
    Channel getByCode(String channelCode);

    /**
     *  通过渠道编排查询对应的渠道列表
     * @param channelOrchestrations
     * @return
     */
    List<Channel> getChannelsByOrchestration(List<ChannelOrchestration> channelOrchestrations);

    /**
     *  通过渠道编排查询对应的渠道列表
     * @param channelOrchestrations
     * @return
     */
    Map<String,ChannelOrchestration> getMapByOrchestration(List<ChannelOrchestration> channelOrchestrations);
}
