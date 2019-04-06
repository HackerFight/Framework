package com.hacker.framework.engine;

import com.hacker.framework.pipeline.Pipeline;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface PipelineAssember {

    Pipeline assemble(String serviceName);
}
