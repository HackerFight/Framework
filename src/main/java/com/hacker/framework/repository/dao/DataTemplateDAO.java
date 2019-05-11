package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.DataTemplateDO;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface DataTemplateDAO {

    /**
     *
     * @param dataTemplateId
     * @return
     */
    DataTemplateDO getByDataTemplateId(String dataTemplateId);

}
