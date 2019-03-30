package com.hacker.framework.pipeline;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public class Pipeline {

    /**
     * 试图
     */
    private Dataview dataview;

    /**
     * 渠道组
     */
    private ChannelGroup channelGroup;


    public Dataview getDataview() {
        return dataview;
    }

    public void setDataview(Dataview dataview) {
        this.dataview = dataview;
    }

    public ChannelGroup getChannelGroup() {
        return channelGroup;
    }

    public void setChannelGroup(ChannelGroup channelGroup) {
        this.channelGroup = channelGroup;
    }
}
