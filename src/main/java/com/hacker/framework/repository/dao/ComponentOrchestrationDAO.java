package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ComponentOrchestrationDO;

import java.util.List;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface ComponentOrchestrationDAO {

    ComponentOrchestrationDO getOrchestrationByComponentCode(String componentCode);

    /**
     * 整和mybatis, 需要使用 @param 注解
     * @param relCode
     * @param relType
     * @return
     */
    List<ComponentOrchestrationDO> getListByRefCode(String relCode, String relType);
}
