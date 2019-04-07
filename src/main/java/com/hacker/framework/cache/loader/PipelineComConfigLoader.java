package com.hacker.framework.cache.loader;

import com.hacker.framework.enums.ComponentDirectionEnum;
import com.hacker.framework.enums.ComponentOrchestrationEnum;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import com.hacker.framework.pipeline.Channel;
import com.hacker.framework.pipeline.ChannelGroup;
import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.pipeline.Pipeline;
import com.hacker.framework.repository.ChannelOrchestrationRepository;
import com.hacker.framework.repository.ChannelRepository;
import com.hacker.framework.repository.ComponentOrchestrationRepository;
import com.hacker.framework.repository.DataviewRepository;
import com.hacker.framework.repository.weave.ChannelOrchestration;
import com.hacker.framework.repository.weave.ComponentOrchestration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
        List<ChannelOrchestration> channelOrchestrations = channelOrchestrationRepository.getListByPipelineCode(key);
        //上面的结果中含有渠道的编码，然后在渠道表中查询渠道的信息
        List<Channel> channels = channelRepository.getChannelsByOrchestration(channelOrchestrations);
        ChannelGroup channelGroup = new ChannelGroup();
        channelGroup.storeChannel(channels);

        //将渠道组保存之链路中
        pipeline.setChannelGroup(channelGroup);

        //加载试图组件
        loadDataviewComponent(dataview);

        //加载渠道组件
        if (null != channels && channels.size() > 0){
            /**
             * 在上面将 channels 保存之 channelGroup 中，然后继续在下面操作channels， 居然同样对 channelGroup 生效？
             * 测试发现，确实ok的
             */
            channels.forEach(this::loadChannelComponent);
        }else {
            throw new GdfException(key, GdfErrorEnum.DATA_VIEW_LOAD_ERROR);
        }

        return pipeline;
    }

    /**
     * 加载试图组建
     * @param dataview
     */
    private void loadDataviewComponent(Dataview dataview) {
        //查询所有试图的组件
        List<ComponentOrchestration> componentOrchestrations = componentOrchestrationRepository.getListByRef(
                dataview.getDataviewCode(), ComponentOrchestrationEnum.DATAVIEW.getCode());

        if (CollectionUtils.isEmpty(componentOrchestrations)){
            throw new GdfException(dataview.getDataviewCode(), GdfErrorEnum.COMPONENT_ORCHESTRATION_LOAD_ERROR);
        }

        List<String> requestComList = new ArrayList<>(4);
        List<String> responseComList = new ArrayList<>(4);

        for (ComponentOrchestration componentOrchestration : componentOrchestrations) {
              if (ComponentDirectionEnum.REQUEST == componentOrchestration.getRunDirection()){
                  requestComList.add(componentOrchestration.getComponentCode());
              }

              if (ComponentDirectionEnum.RESPONSE == componentOrchestration.getRunDirection()){
                  responseComList.add(componentOrchestration.getComponentCode());
              }

              if (ComponentDirectionEnum.DISPATCH == componentOrchestration.getRunDirection()){
                  dataview.setChannelDispatchCom(componentOrchestration.getComponentCode());
              }
        }

        dataview.setRequestComList(requestComList);
        dataview.setResponseComList(responseComList);

    }

    /**
     * 加载渠道组件
     * @param channel
     */
    private void loadChannelComponent(Channel channel) {
        List<ComponentOrchestration> componentOrchestrations = componentOrchestrationRepository.getListByRef(
                channel.getChannelCode(), ComponentOrchestrationEnum.CHANNEL.getCode());

        if (CollectionUtils.isEmpty(componentOrchestrations)){
            throw new GdfException(channel.getChannelCode(), GdfErrorEnum.COMPONENT_ORCHESTRATION_LOAD_ERROR);
        }

        List<String> requestComList = new ArrayList<>(4);
        List<String> responseComList = new ArrayList<>(4);

        for (ComponentOrchestration componentOrchestration : componentOrchestrations) {

            if (ComponentDirectionEnum.REQUEST == componentOrchestration.getRunDirection()){
                requestComList.add(componentOrchestration.getComponentCode());
            }

            if (ComponentDirectionEnum.RESPONSE == componentOrchestration.getRunDirection()){
                responseComList.add(componentOrchestration.getComponentCode());
            }

            if (ComponentDirectionEnum.TELCOM == componentOrchestration.getRunDirection()){
                channel.setNetTelCom(componentOrchestration.getComponentCode());
            }

            channel.setRequestComList(requestComList);
            channel.setResponseComList(responseComList);

        }
    }
}
