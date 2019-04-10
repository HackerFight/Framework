package com.hacker.framework.hbase;

import java.util.List;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public class RowUnit {

    private String rowKey;

    private List<CellUnit> cellUnits;

    private long timeStamp;

    public RowUnit(String rowKey, List<CellUnit> cellUnits, long timeStamp){
        this.rowKey = rowKey;
        this.cellUnits = cellUnits;
        this.timeStamp = timeStamp;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public List<CellUnit> getCellUnits() {
        return cellUnits;
    }

    public void setCellUnits(List<CellUnit> cellUnits) {
        this.cellUnits = cellUnits;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
