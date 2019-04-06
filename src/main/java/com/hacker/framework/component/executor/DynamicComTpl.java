package com.hacker.framework.component.executor;

import com.hacker.framework.cache.loader.DataLoader;
import com.hacker.framework.component.CommonComTemplate;
import com.hacker.framework.component.DynamicComConfig;
import com.hacker.framework.component.MetaComConfig;
import com.hacker.framework.context.PipelineContext;
import groovy.lang.GroovyObject;

import java.util.Random;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class DynamicComTpl extends CommonComTemplate {

    /**
     * 为什么这个loader 不再初始化的时候加载呢？
     */
    private DataLoader<String, DynamicComConfig> dynamicComConfigDataLoader;

    private Random random = new Random();

    @Override
    public Object doRun(MetaComConfig metaComConfig, PipelineContext ctx) {

        DynamicComConfig dynamicComConfig = loadConfig(metaComConfig);

        int prePercent = dynamicComConfig.getPrePercent();

        GroovyObject prodGroovy = dynamicComConfig.getProdGroovy();
        GroovyObject preGroovy = dynamicComConfig.getPreGroovy();

        //[0,100}
        int bound = random.nextInt(100);

        if (bound <= prePercent){
            preGroovy.invokeMethod("run", ctx);
        }else {
            prodGroovy.invokeMethod("run", ctx);
        }
        return null;
    }

    private DynamicComConfig loadConfig(MetaComConfig metaComConfig){
        return dynamicComConfigDataLoader.load(metaComConfig.getComponentCode());
    }

    public void setDynamicComConfigDataLoader(DataLoader<String, DynamicComConfig> dynamicComConfigDataLoader) {
        this.dynamicComConfigDataLoader = dynamicComConfigDataLoader;
    }
}
