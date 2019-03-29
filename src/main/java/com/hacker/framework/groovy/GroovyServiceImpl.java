package com.hacker.framework.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * Created by hacker on 2019/3/29 0029.
 */
public class GroovyServiceImpl implements GroovyService{

    private final GroovyClassLoader groovyClassLoader;
    {
        ClassLoader classLoader = GroovyServiceImpl.class.getClassLoader();
        groovyClassLoader = new GroovyClassLoader(classLoader);
    }

    @Override
    public GroovyObject compileScript(String script){
        try {
            ClassLoader classLoader = GroovyServiceImpl.class.getClassLoader();
            GroovyClassLoader groovyClassLoader = new GroovyClassLoader(classLoader);
            Class<?> groovyClass = groovyClassLoader.parseClass(script);
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            return groovyObject;
        } catch (InstantiationException | IllegalAccessException e) {
            //todo... 异常处理
            throw new RuntimeException("解析脚本错误");
        }
    }

    @Override
    public GroovyObject compileScript(File file) {
        try {
            //todo... 这样行不行?
//            ClassLoader classLoader = GroovyServiceImpl.class.getClassLoader();
//            GroovyClassLoader groovyClassLoader = new GroovyClassLoader(classLoader);
            Class<?> groovyClass = groovyClassLoader.parseClass(file);
            return (GroovyObject) groovyClass.newInstance();
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            //TODO....
            throw new RuntimeException("解析脚本异常：" + e.getMessage());
        }
    }












}
