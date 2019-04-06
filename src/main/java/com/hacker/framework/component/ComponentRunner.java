package com.hacker.framework.component;

import com.hacker.framework.context.PipelineContext;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ComponentRunner {

    Object runComponent(String comCode, PipelineContext pipelineContext);
}
