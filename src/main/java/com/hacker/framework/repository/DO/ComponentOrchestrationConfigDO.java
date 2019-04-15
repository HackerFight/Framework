package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:15
 *
 * @desc
 */
public class ComponentOrchestrationConfigDO {

    private String componentCode;

    /**
     * 关联主体编码
     */
    private String relCode;

    /**
     * 关联主体类型：dataview-视图 channel-渠道
     */
    private String relType;
    /**
     * 配置key
     */
    private String confKey;

    private String confVal;
    /**
     * 所属配置组
     */
    private String confGroup;

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

    public String getConfKey() {
        return confKey;
    }

    public void setConfKey(String confKey) {
        this.confKey = confKey;
    }

    public String getConfVal() {
        return confVal;
    }

    public void setConfVal(String confVal) {
        this.confVal = confVal;
    }

    public String getConfGroup() {
        return confGroup;
    }

    public void setConfGroup(String confGroup) {
        this.confGroup = confGroup;
    }
}
