package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ComponentMetaDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface ComponentMetaDAO {

    /**
     * 需要使用 @param("") 注解
     * @param componentType
     * @param componentCode
     * @return
     */
    ComponentMetaDO getByTypeAndCode(@Param("componentType") String componentType,
                                     @Param("componentCode") String componentCode);

    /**
     * 通过组件编码 查询组件元数据
     * @param componentCode
     * @return
     */
    ComponentMetaDO getByCode(String componentCode);
}
