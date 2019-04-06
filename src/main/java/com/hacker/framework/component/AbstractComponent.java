package com.hacker.framework.component;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public abstract class AbstractComponent<T> implements Component<T> {

    /**
     * 定义一个普通方法，内部调用了接口的方法，但是注意，当前类的非抽象实现类，必须
     * 实现 Component 接口的 doRun() 方法
     * @param metaComConfig
     * @param ctx
     * @return
     */
    public Object run(MetaComConfig metaComConfig, T ctx){
        /**
         * 这个 doRun() 方法是接口的，这里不做实现，直接调用，由实现类来具体执行
         */
        Object o = doRun(metaComConfig, ctx);
        return o;
    }
}
