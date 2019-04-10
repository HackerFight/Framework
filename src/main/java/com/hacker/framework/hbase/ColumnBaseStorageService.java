package com.hacker.framework.hbase;


/**
 * Created by hacker on 2019/4/7 0007.
 */
public interface ColumnBaseStorageService {

    boolean createSchema(String tableName);

    boolean  removeSchema(String tableName);

    boolean saveRow(String tableName, RowUnit rowUnit);
    /**
     * 尽量使用异步存储
     * @param tableName
     * @param rowUnit
     * @return
     */
    boolean asyncSaveRow(String tableName, RowUnit rowUnit);

    RowUnit getRow(String tableName, String rowKey);

    boolean deleteRow(String tableName, String rowKey);

}
