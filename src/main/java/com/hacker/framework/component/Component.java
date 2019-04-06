package com.hacker.framework.component;

import com.hacker.framework.context.PipelineContext;

/**
 * Created by Administrator on 2019/4/6 0006.
 */
public interface Component<T> {

    /**
     * 这个参数范型是什么呢？
     * @param metaComConfig
     * @param ctx
     * @return
     */
    Object doRun(MetaComConfig metaComConfig, T ctx);
}
