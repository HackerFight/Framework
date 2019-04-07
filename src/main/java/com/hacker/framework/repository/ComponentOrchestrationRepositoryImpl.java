package com.hacker.framework.repository;

import com.hacker.framework.repository.dao.ComponentOrchestrationDAO;
import com.hacker.framework.repository.weave.ComponentOrchestration;

import java.util.List;

/**
 * Created by hacker on 2019/4/7 0007.
 */
public class ComponentOrchestrationRepositoryImpl implements ComponentOrchestrationRepository {

    private ComponentOrchestrationDAO componentOrchestrationDAO;

    /**
     * todo....
     * @param refCode
     * @param refType
     * @return
     */
    @Override
    public List<ComponentOrchestration> getListByRef(String refCode, String refType) {
       // return componentOrchestrationDAO.getListByRefCode(refCode, refType);
        return null;
    }
}
