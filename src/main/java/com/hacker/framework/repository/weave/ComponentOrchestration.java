package com.hacker.framework.repository.weave;

import com.hacker.framework.enums.ComponentDirectionEnum;
import com.hacker.framework.enums.ComponentOrchestrationEnum;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class ComponentOrchestration {

    private String componentCode;

    /**
     * 关联主体编码：channel-dataview
     */
    private String relCode;
    /**
     * 关联主体类型，渠道-channel; 试图：dataview
     */
    private ComponentOrchestrationEnum relType;

    /**
     * 运行方向，request response dispatch telcom
     */
    private ComponentDirectionEnum runDirection;

    /**
     * request/response:1-x; disptach:0, telcom:0
     */
    private String runOrder;

    /**
     * 编排上下文信息，json格式
     */
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

    public ComponentOrchestrationEnum getRelType() {
        return relType;
    }

    public void setRelType(ComponentOrchestrationEnum relType) {
        this.relType = relType;
    }

    public ComponentDirectionEnum getRunDirection() {
        return runDirection;
    }

    public void setRunDirection(ComponentDirectionEnum runDirection) {
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
