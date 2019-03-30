package com.hacker.framework.pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hacker on 2019/3/30 0030.
 *
 * 渠道组
 */
public class ChannelGroup {

    /**
     * 渠道集合
     */
    private List<Channel> channelList;

    /**
     * 渠道编码对应的渠道对象
     */
    private Map<String, Channel> channelMap;

    /**
     * 将集合中数据按照编码保存到map中
     * @param channels
     */
    public void storeChannel(List<Channel> channels){
        if (channels != null && !channels.isEmpty()){
            if (channelMap == null){
                channelMap = new HashMap<>(channels.size());
            }

            channels.forEach(item -> channelMap.put(item.getChannelCode(), item));
        }
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public Map<String, Channel> getChannelMap() {
        return channelMap;
    }

    public void setChannelMap(Map<String, Channel> channelMap) {
        this.channelMap = channelMap;
    }
}
