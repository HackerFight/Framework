package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.DynamicComponentDO;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface DynamicComponentDAO {

    /**
     * 同故宫组件编码查询动态组件
     * @param componentCode
     * @return
     */
    DynamicComponentDO getByCode(String componentCode);
}
