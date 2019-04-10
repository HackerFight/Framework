package com.hacker.framework.hbase;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public class CellUnit {

    private String columnFamily;

    private String column;

    private String value;

    /**
     * 数据写入缓存时间戳
     */
    private long timeStamp;

    public CellUnit(String columnFamily, String column, String value, long timeStamp){
        this.columnFamily = columnFamily;
        this.column = column;
        this.value = value;
        this.timeStamp = timeStamp;
    }

    public CellUnit(String columnFamily, String column, String value){
        this.columnFamily = columnFamily;
        this.column = column;
        this.value = value;
    }

    public String getColumnFamily() {
        return columnFamily;
    }

    public void setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
