package com.hacker.framework.repository.dao;

import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.repository.DO.DataviewDO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface DataviewDAO {

    /**
     * 通过链路编码获取视图对象（视图-链路一对一）
     * @param pipelineCode
     * @return
     */
    DataviewDO getByPipelineCode(String pipelineCode);
}
