package com.hacker.framework.repository.DO;
import com.hacker.framework.repository.weave.ComponentOrchestration;

/**
 * Created by hacker on 2019/4/6 0006.
 *
 * DO 是和数据表对应的类
 * @see ComponentOrchestration todo....
 */
public class ComponentOrchestrationDO {

    private String componentCode;

    private String relCode;

    private String relType;

    private String runDirection;

    private String runOrder;

    private String context;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    public String getRunDirection() {
        return runDirection;
    }

    public void setRunDirection(String runDirection) {
        this.runDirection = runDirection;
    }

    public String getRunOrder() {
        return runOrder;
    }

    public void setRunOrder(String runOrder) {
        this.runOrder = runOrder;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
