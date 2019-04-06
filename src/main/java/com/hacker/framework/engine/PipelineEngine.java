package com.hacker.framework.engine;

import com.hacker.framework.service.CommonQueryParam;
import com.hacker.framework.service.CommonQueryResult;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface PipelineEngine{

    CommonQueryResult service(CommonQueryParam commonQueryParam);
}
