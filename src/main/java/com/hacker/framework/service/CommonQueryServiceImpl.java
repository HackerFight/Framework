package com.hacker.framework.service;

import com.hacker.framework.engine.PipelineEngine;
import com.hacker.framework.ex.GdfErrorEnum;
import com.hacker.framework.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hacker
 * +.on 2019/4/7 0007.
 */
public class CommonQueryServiceImpl implements CommonQueryService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonQueryServiceImpl.class);

    @Autowired
    private PipelineEngine standardPipelineEngine;

    @Override
    public CommonQueryResult query(CommonQueryParam commonQueryParam) {
        //做一些参数检验，权限校验等...

        CommonQueryResult commonQueryResult = null;
        try{
            commonQueryResult = standardPipelineEngine.service(commonQueryParam);
        }catch (Exception e){
            LoggerUtil.error(LOGGER, e);
            commonQueryResult = new CommonQueryResult();
            commonQueryResult.setSuccess(false);
            commonQueryResult.setErrorCode(GdfErrorEnum.SYS_EXCEPTION.getCode());
            commonQueryResult.setErrorMessage(GdfErrorEnum.SYS_EXCEPTION.getMsg());
        }
        return commonQueryResult;
    }
}
