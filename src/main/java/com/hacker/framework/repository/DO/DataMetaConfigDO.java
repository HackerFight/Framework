package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:13
 *
 * @desc
 */
public class DataMetaConfigDO {

    private String dataTemplateId;

    private String fieldName;

    private String fieldType;

    private String memo;

    private String extraInfo;

    public String getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(String dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
