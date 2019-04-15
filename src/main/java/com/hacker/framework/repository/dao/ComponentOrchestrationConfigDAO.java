package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ComponentOrchestrationConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:24
 *
 * @desc
 */
public interface ComponentOrchestrationConfigDAO {

    int insert(ComponentOrchestrationConfigDO componentOrchestrationConfigDO);

    List<ComponentOrchestrationConfigDO> getConfigListByRefCode(@Param("relCode") String relCode,
                                                                @Param("relType") String relType,
                                                                @Param("componentCode") String componentCode);
}
