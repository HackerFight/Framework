package com.hacker.framework.groovy;

import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * Created by hacker on 2019/3/29 0029.
 */
public interface GroovyService {

    /**
     * 直接编译字符串形式的脚本，比如写到数据库中的脚本
     * @param script
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    GroovyObject compileScript(String script) throws InstantiationException, IllegalAccessException;

    /**
     * 编译文件形式的脚本
     * @param file
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    GroovyObject compileScript(File file) throws InstantiationException, IllegalAccessException, IOException;

}
