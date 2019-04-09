package com.hacker.framework.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by hacker on 2019/4/9 0009.
 */
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(String sql) {
        this.jdbcTemplate.update(sql);
    }
}
