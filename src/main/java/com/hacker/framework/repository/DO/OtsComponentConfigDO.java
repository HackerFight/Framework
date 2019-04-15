package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:17
 *
 * @desc
 */
public class OtsComponentConfigDO {

    private String componentCode;

    /**
     * 固定缓存rowkey值
     */
    private String fixedRowKeyValue;

    /**
     * 缓存key生产规则
     */
    private String rowKeyRule;

    private String dataTemplateId;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getFixedRowKeyValue() {
        return fixedRowKeyValue;
    }

    public void setFixedRowKeyValue(String fixedRowKeyValue) {
        this.fixedRowKeyValue = fixedRowKeyValue;
    }

    public String getRowKeyRule() {
        return rowKeyRule;
    }

    public void setRowKeyRule(String rowKeyRule) {
        this.rowKeyRule = rowKeyRule;
    }

    public String getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(String dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }
}
