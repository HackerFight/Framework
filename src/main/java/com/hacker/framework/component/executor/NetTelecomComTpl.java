package com.hacker.framework.component.executor;

import com.hacker.framework.component.CommonComTemplate;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.ChannelContext;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.ex.ComException;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.ex.GdfException;
import com.hacker.framework.net.NetRequest;
import com.hacker.framework.net.NetResponse;
import com.hacker.framework.net.ProtocolService;
import com.hacker.framework.net.ProtocolTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Administrator on 2019/4/6 0006.
 */
public class NetTelecomComTpl extends CommonComTemplate {

    @Autowired
    private ProtocolService protocolService;

    @Override
    public Object doRun(MetaComConfig metaComConfig, PipelineContext ctx) {

        ChannelContext channelContext = ctx.getChannelContext(metaComConfig.getComponentCode());
        if (!channelContext.isEnableRemoteInvoke()){
            //缓存读到，禁用远程调用
            return null;
        }

        NetRequest netRequest = channelContext.getNetRequest();
        ProtocolTypeEnum protocolTypeEnum = netRequest.getProtocolTypeEnum();

        try {
            NetResponse netResponse;
            switch (protocolTypeEnum){

                case HTTP_GET:
                    netResponse = protocolService.get(netRequest);
                    break;
                case HTTP_POST:
                    netResponse = protocolService.post(netRequest);
                    break;
                default:
                    throw new GdfException(metaComConfig.getComponentCode(), GdfErrorEnum.SYS_EXCEPTION);
            }

            channelContext.setNetResponse(netResponse);

        } catch (IOException e){
            throw new GdfException(metaComConfig.getComponentCode(), GdfErrorEnum.IO_EXCEPTION);
        } catch (Exception e){
            throw new ComException(metaComConfig.getComponentCode(), GdfErrorEnum.TELECOM_EXCEPTION);
        }

        return null;
    }
}
