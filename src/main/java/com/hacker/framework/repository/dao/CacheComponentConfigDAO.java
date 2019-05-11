package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.CacheComponentConfigDO;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface CacheComponentConfigDAO {

    /**
     * 插入数据库（现在是都是sql语句手动插入的，后面会单独做一个web服务，通过页面配置实现）
     * @param cacheComponentConfigDO
     * @return
     */
    int insert(CacheComponentConfigDO cacheComponentConfigDO);

    /**
     * 通过组件编码获取缓存配置信息
     * @param componentCode
     * @return
     */
    CacheComponentConfigDO getByComponentCode(String componentCode);

    /**
     * 删除组件
     * @param componentCode
     * @return
     */
    int deleteByComponentCode(String componentCode);

}
