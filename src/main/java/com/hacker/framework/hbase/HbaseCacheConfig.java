package com.hacker.framework.hbase;

import java.util.List;

/**
 * Created by hacker on 2019/4/16 0016-下午 10:04
 *
 * @desc
 */
public class HbaseCacheConfig {

    private String componentCode;

    private String tableName;

    private String[] rowKeyFieldList;

    private String columnFamily = "f";

    private List<String> columnNames;

    private int cacheInterval;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getRowKeyFieldList() {
        return rowKeyFieldList;
    }

    public void setRowKeyFieldList(String[] rowKeyFieldList) {
        this.rowKeyFieldList = rowKeyFieldList;
    }

    public String getColumnFamily() {
        return columnFamily;
    }

    public void setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public int getCacheInterval() {
        return cacheInterval;
    }

    public void setCacheInterval(int cacheInterval) {
        this.cacheInterval = cacheInterval;
    }
}
