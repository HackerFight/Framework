package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.OtsComponentConfigDO;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:24
 *
 * @desc
 */
public interface OtsComponentConfigDAO {

    OtsComponentConfigDO getByComponentCode(String componentCode);
}
