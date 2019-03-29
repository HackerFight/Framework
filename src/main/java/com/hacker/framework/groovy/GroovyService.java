package com.hacker.framework.groovy;

import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * Created by hacker on 2019/3/29 0029.
 */
public interface GroovyService {

    GroovyObject compileScript(String script) throws InstantiationException, IllegalAccessException;

    GroovyObject compileScript(File file) throws InstantiationException, IllegalAccessException, IOException;

}
