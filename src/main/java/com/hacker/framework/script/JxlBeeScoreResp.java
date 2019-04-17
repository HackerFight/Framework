package com.hacker.framework.script;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hacker.framework.context.ChannelContext;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.net.NetResponse;
import com.hacker.framework.service.CommonQueryResult;
import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

/**
 * Created by hacker on 2019/4/18 0018-上午 12:17
 *
 * @desc
 */
public class JxlBeeScoreResp extends RunGroovy {

    private static final Logger LOGGER = LoggerFactory.getLogger(JxlBeeScoreResp.class);

    private static final int STATUS_CODE_SUCCESS = 200;

    private static final String CHANNEL_CODE = "";

    private static final String QUERY_BEE_SCORE_SUCCESS_CODE = "XMF_SEARCH_SUCCESS";

    @Override
    protected void run(PipelineContext pipelineContext) {
        ChannelContext channelContext = pipelineContext.getChannelContext(CHANNEL_CODE);

        NetResponse netResponse = channelContext.getNetResponse();

        CommonQueryResult commonQueryResult = new CommonQueryResult();

        int statusCode = netResponse.getStatusCode();
        String entryMessage = netResponse.getEntryMessage();

        if (STATUS_CODE_SUCCESS != statusCode){

            commonQueryResult.setSuccess(false);
            commonQueryResult.setErrorCode(String.valueOf(statusCode));
            commonQueryResult.setErrorMessage("响应失败，请联系开发人员");
            channelContext.errorChannel();
            pipelineContext.completeAndFail(commonQueryResult);
            return;
        }

        try {
            JSONObject netMessageObject = JSONObject.parseObject(entryMessage);
            String beeScoreCode = netMessageObject.getString("code");
            if (Objects.equals(QUERY_BEE_SCORE_SUCCESS_CODE, beeScoreCode)){
                commonQueryResult.setSuccess(true);
                /**
                 * 设置结果集
                 * 这是下游数据源返回的数据结构
                 *  {
                 *      code:XML_SEARCH_SUCCESS,
                 *      code_description:查询成功,
                 *      data:{
                 *            bee_score:560
                 *          },
                 *      spend_time:30
                 *  }
                 *
                 *  这里resultMap 是封装给 上游业务方的，是一个 Map, 其中有一个 key 是 data, value 是一个JSON 字符串
                 */
                commonQueryResult.setResultMap(JSON.parseObject(entryMessage, new TypeReference<Map<String, String>>(){}));

                channelContext.sucChannel();
                pipelineContext.completeAndSuc(commonQueryResult);

            }else {
                commonQueryResult.setSuccess(false);
                commonQueryResult.setErrorCode(beeScoreCode);
                commonQueryResult.setErrorMessage(netMessageObject.getString("code_description"));
                channelContext.errorChannel();
                pipelineContext.completeAndFail(commonQueryResult);
            }
        } catch (Exception e) {
            LoggerUtil.error(LOGGER, e, "解析报文错误：" + entryMessage);
            commonQueryResult.setSuccess(false);
            commonQueryResult.setErrorCode(GdfErrorEnum.NET_MSG_PARSE_EXCEPTION.getCode());
            commonQueryResult.setErrorMessage(GdfErrorEnum.NET_MSG_PARSE_EXCEPTION.getMsg());
            channelContext.errorChannel();
            pipelineContext.completeAndFail(commonQueryResult);
        }
    }
}
