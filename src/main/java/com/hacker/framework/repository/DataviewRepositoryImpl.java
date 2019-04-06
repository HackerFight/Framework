package com.hacker.framework.repository;

import com.hacker.framework.pipeline.Dataview;
import com.hacker.framework.repository.DO.DataviewDO;
import com.hacker.framework.repository.dao.DataviewDAO;

import java.util.function.Function;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DataviewRepositoryImpl implements DataviewRepository {

    private DataviewDAO dataviewDAO;

    @Override
    public Dataview getByPipelineCode(String pipelineCode) {
        return dotoDomainFunc.apply(dataviewDAO.getByPipelineCode(pipelineCode));
    }

    private static Function<DataviewDO, Dataview> dotoDomainFunc = dataviewDO -> {
        if (null == dataviewDO){
            return null;
        }

        Dataview dataview = new Dataview();
        dataview.setDataviewCode(dataviewDO.getDataviewCode());
        dataview.setAvailable(dataviewDO.isAvailable());

        return dataview;
    };
}

