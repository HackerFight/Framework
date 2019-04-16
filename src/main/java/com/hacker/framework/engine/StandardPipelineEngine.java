package com.hacker.framework.engine;

import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.context.PipelineStatusEnum;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.pipeline.Pipeline;
import com.hacker.framework.service.CommonQueryParam;
import com.hacker.framework.service.CommonQueryResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class StandardPipelineEngine implements  PipelineEngine{

    @Autowired
    private PipelineAssember pipelineAssember;

    @Autowired
    private PipelineLanucher pipelineLanucher;

    @Override
    public CommonQueryResult service(CommonQueryParam commonQueryParam) {
        Pipeline pipeline = pipelineAssember.assemble(commonQueryParam.getServiceName());
        if (null == pipeline){
            CommonQueryResult commonQueryResult = new CommonQueryResult();
            commonQueryResult.setSuccess(false);
            commonQueryResult.setErrorCode(GdfErrorEnum.NO_SERVICE.getCode());
            commonQueryResult.setErrorMessage(GdfErrorEnum.NO_SERVICE.getMsg());
            return commonQueryResult;
        }

        Dataview dataview = pipeline.getDataview();
        if (null == dataview){
          CommonQueryResult commonQueryResult = new CommonQueryResult();
          commonQueryResult.setSuccess(false);
          commonQueryResult.setErrorCode(GdfErrorEnum.SERVICE_NOT_AVAIABLE.getCode());
          commonQueryResult.setErrorMessage(GdfErrorEnum.SERVICE_NOT_AVAIABLE.getMsg());
          return commonQueryResult;
        }

        PipelineContext ctx = new PipelineContext();
        ctx.setPipelineStatusEnum(PipelineStatusEnum.RUNNING);
        ctx.setDataviewCode(commonQueryParam.getServiceName());
        ctx.setStartTime(System.currentTimeMillis());
        CommonQueryResult commonQueryResult = new CommonQueryResult();
        ctx.setCommonQueryResult(commonQueryResult);
        Map<String, String> conditions = commonQueryParam.getQueryConditions();
        for (Map.Entry<String, String> entry : conditions.entrySet()) {
            ctx.addRunProperties(entry.getKey(), entry.getValue());
        }

        pipelineLanucher.lanuchDataview(dataview, ctx);
        commonQueryResult = ctx.getCommonQueryResult();

        return commonQueryResult;
    }
}
