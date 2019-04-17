package com.hacker.framework.script;

import com.hacker.framework.context.PipelineContext;

/**
 * Created by hacker on 2019/4/18 0018-上午 12:08
 *
 * @desc
 */
public abstract class RunGroovy {
    /**
     * 脚本都需需要实现 RunGroovy ,其目的有2个：
     *  1.动态脚本执行器 DynamicComTpl 调用的是 run 方法
     *  2.保证入参都是 PipelineContext
     * @param pipelineContext
     */
    protected abstract void run(PipelineContext pipelineContext);
}
