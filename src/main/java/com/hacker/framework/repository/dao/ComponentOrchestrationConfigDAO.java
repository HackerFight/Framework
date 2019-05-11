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

    /**
     * 插入数据,现在都是通过sql语句写入到数据库中的，后面会单独做一个web服务，
     * 通过页面来配置
     * @param componentOrchestrationConfigDO
     * @return
     */
    int insert(ComponentOrchestrationConfigDO componentOrchestrationConfigDO);

    /**
     *
     * @param relCode
     * @param relType
     * @param componentCode
     * @return
     */
    List<ComponentOrchestrationConfigDO> getConfigListByRefCode(@Param("relCode") String relCode,
                                                                @Param("relType") String relType,
                                                                @Param("componentCode") String componentCode);
}
