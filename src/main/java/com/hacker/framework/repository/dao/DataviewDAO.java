package com.hacker.framework.repository.dao;

import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.repository.DO.DataviewDO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface DataviewDAO {

    DataviewDO getByPipelineCode(String pipelineCode);
}
