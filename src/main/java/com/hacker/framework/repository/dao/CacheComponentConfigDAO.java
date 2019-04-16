package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.CacheComponentConfigDO;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface CacheComponentConfigDAO {

    int insert(CacheComponentConfigDO cacheComponentConfigDO);

    CacheComponentConfigDO getByComponentCode(String componentCode);

    int deleteByComponentCode(String componentCode);

}
