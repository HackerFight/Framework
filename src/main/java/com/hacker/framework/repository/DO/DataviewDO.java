package com.hacker.framework.repository.DO;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DataviewDO extends BaseDO{

    private String dataviewCode;

    private String dataviewName;

    private String dataviewDesc;

    private String businessOwner;

    private String techOwner;

    private String reliableLevel;

    private boolean available;

    private String creator;

    private String modifier;

    private String extInfo;

    public String getDataviewCode() {
        return dataviewCode;
    }

    public void setDataviewCode(String dataviewCode) {
        this.dataviewCode = dataviewCode;
    }

    public String getDataviewName() {
        return dataviewName;
    }

    public void setDataviewName(String dataviewName) {
        this.dataviewName = dataviewName;
    }

    public String getDataviewDesc() {
        return dataviewDesc;
    }

    public void setDataviewDesc(String dataviewDesc) {
        this.dataviewDesc = dataviewDesc;
    }

    public String getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner;
    }

    public String getTechOwner() {
        return techOwner;
    }

    public void setTechOwner(String techOwner) {
        this.techOwner = techOwner;
    }

    public String getReliableLevel() {
        return reliableLevel;
    }

    public void setReliableLevel(String reliableLevel) {
        this.reliableLevel = reliableLevel;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}
