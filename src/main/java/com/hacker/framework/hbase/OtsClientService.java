package com.hacker.framework.hbase;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public interface OtsClientService {

    boolean createSchema(String tableName);

    boolean existsSchema(String tableName);

    boolean deleteSchema(String tableName);

    boolean saveRow(String tableName, String rowKey, RowUnit rowUnit);

    boolean saveRowRetry(String tableName, String rowKey, RowUnit rowUnit);

    boolean saveRowRetry2(String tableName, String rowKey, RowUnit rowUnit);

    RowUnit getRow(String tableName, String rowKey);

    boolean deleteRow(String tableName, String rowKey);
}
