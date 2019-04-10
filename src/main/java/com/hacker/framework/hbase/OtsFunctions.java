package com.hacker.framework.hbase;

/**
 * Created by hacker on 2019/4/10 0010.
 */

@FunctionalInterface
public interface OtsFunctions<T, R> {

    R apply(T t) throws Exception;
}
