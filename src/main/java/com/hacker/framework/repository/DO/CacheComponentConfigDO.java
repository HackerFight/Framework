package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:20
 *
 * @desc
 */
public class CacheComponentConfigDO {

    private String componentCode;

    private String rowKeyRule;

    private int cacheTime;

    /**
     * 需要处理的列
     */
    private String accessColumn;

    private String dataTemplateId;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getRowKeyRule() {
        return rowKeyRule;
    }

    public void setRowKeyRule(String rowKeyRule) {
        this.rowKeyRule = rowKeyRule;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }

    public String getAccessColumn() {
        return accessColumn;
    }

    public void setAccessColumn(String accessColumn) {
        this.accessColumn = accessColumn;
    }

    public String getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(String dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }
}
