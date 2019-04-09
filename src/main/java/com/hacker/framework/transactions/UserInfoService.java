package com.hacker.framework.transactions;

/**
 * Created by hacker on 2019/4/9 0009.
 */
public interface UserInfoService {

    /**
     * 我只是为了演示编程式事务，所以这里就简单定义一下
     * @param sql
     */
    void update(String sql);
}
