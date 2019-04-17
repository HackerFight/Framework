package com.hacker.framework.script;

import com.hacker.framework.context.ChannelContext;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.net.NetRequest;
import com.hacker.framework.net.ProtocolTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hacker on 2019/4/18 0018-上午 12:11
 *
 * 在实际中，这个脚本是写到数据库中的，从数据库中读取
 * @desc
 */
public class JxlBeeScoreReq extends RunGroovy {

    private static final Logger Logger = LoggerFactory.getLogger(JxlBeeScoreReq.class);

    //请求的url
    private static final String URL = "";

    //渠道编码
    private static final String CHANNEL_CODE = "";


    @Override
    protected void run(PipelineContext pipelineContext) {
        NetRequest netRequest = new NetRequest();
        netRequest.setUrl(URL);

        netRequest.setProtocolTypeEnum(ProtocolTypeEnum.HTTP_GET);

        buildParam(netRequest, pipelineContext);

        ChannelContext channelContext = pipelineContext.getChannelContext(CHANNEL_CODE);
        channelContext.enableRemoteInvoke(netRequest);
    }

    /**
     * 构建参数
     * @param netRequest
     * @param pipelineContext
     */
    private void buildParam(NetRequest netRequest, PipelineContext pipelineContext) {
        //这个参数的值，在请求的时候封装到了 runProperty 属性中了
        netRequest.addUrlParam("name", (String) pipelineContext.getRunProperty("name"));
        netRequest.addUrlParam("id_card", (String) pipelineContext.getRunProperty("id_card"));
        netRequest.addUrlParam("phone", (String) pipelineContext.getRunProperty("phone"));
        netRequest.addUrlParam("type", (String) pipelineContext.getRunProperty("type"));
    }
}
