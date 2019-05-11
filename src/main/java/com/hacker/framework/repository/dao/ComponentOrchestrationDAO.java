package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ComponentOrchestrationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface ComponentOrchestrationDAO {

    /**
     * 通过组件编码获取组件编排
     * @param componentCode
     * @return
     */
    ComponentOrchestrationDO getOrchestrationByComponentCode(String componentCode);

    /**
     * 整和mybatis, 需要使用 @param 注解
     * @param relCode
     * @param relType
     * @return
     */
    List<ComponentOrchestrationDO> getListByRefCode(@Param("relCode") String relCode,
                                                    @Param("relType") String relType);
}
