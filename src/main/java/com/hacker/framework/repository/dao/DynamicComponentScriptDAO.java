package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.DynamicComponentDO;
import com.hacker.framework.repository.DO.DynamicComponentScriptDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface DynamicComponentScriptDAO {

    DynamicComponentScriptDO getByComponentCode(String componentCode);

    /**
     * 整和mybatis，需要使用 @param 注解
     * @param componentCode
     * @param version
     * @return
     */
    DynamicComponentScriptDO getByCodeAndVersion(@Param("componentCode") String componentCode,
                                                 @Param("version") Integer version);
}
