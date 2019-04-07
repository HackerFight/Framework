package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ComponentMetaDO;

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
    ComponentMetaDO getByTypeAndCode(String componentType, String componentCode);


    ComponentMetaDO getByCode(String componentCode);
}
