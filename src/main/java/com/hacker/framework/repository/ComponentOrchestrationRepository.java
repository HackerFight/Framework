package com.hacker.framework.repository;

import com.hacker.framework.repository.weave.ComponentOrchestration;

import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ComponentOrchestrationRepository {

    List<ComponentOrchestration> getListByRef(String refCode, String refType);
}
