package com.hacker.framework.repository;

import com.hacker.framework.pipeline.Dataview;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface DataviewRepository {

    Dataview getByPipelineCode(String pipelineCode);
}
