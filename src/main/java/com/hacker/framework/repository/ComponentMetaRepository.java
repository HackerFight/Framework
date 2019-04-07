package com.hacker.framework.repository;

import com.hacker.framework.component.DynamicComConfig;
import com.hacker.framework.component.MetaComConfig;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface ComponentMetaRepository {

    DynamicComConfig getDynamicComByCode(String componentCode);

    MetaComConfig getMetaComByCode(String componentCode);
}
