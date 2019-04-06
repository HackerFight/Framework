package com.hacker.framework.engine;

import com.hacker.framework.constants.CacheItemConstants;
import com.hacker.framework.cache.CacheMap;
import com.hacker.framework.cache.enums.ExpireTypeEnum;
import com.hacker.framework.cache.loader.DataLoader;
import com.hacker.framework.pipeline.Pipeline;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class StandardPipelineAssember implements PipelineAssember, InitializingBean {

    private DataLoader<String, Pipeline> pipelineDataLoader;

    private CacheMap<String, Pipeline> pipelineCacheMap;

    /**
     * 从缓存中读取数据吗，但是由于我没有设置过缓存，所以需要通过 CacheLoader 的 load 方法加载缓存
     * 这里虽然时通过 pipelineCacheMap.get(serviceName) 获取数据，但实际上调用的时 GuavaCacheImpl 的get 方法
     * 当如果没有数据的时候，他就会通过 CacheLoader 的 load 方法加载数据
     *
     * 实际上在 化法方法中，做了一些初始化的配置,但是整个Cache 中并没有数据，当调用get 的时候，由于没有数据
     * 所以CacheLoader 会加载数据
     * @param serviceName
     * @return
     */
    @Override
    public Pipeline assemble(String serviceName) {
        return pipelineCacheMap.get(serviceName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 调用的是三个参数的构造器，第一个是缓存名称，第二个是失效类型，第三个是数据加载器，我们需要的数据
         * 就是通过他来加载的
         */
        pipelineCacheMap = new CacheMap<String, Pipeline>(CacheItemConstants.PIPELINE_CONFIG,
                ExpireTypeEnum.REFRESH_AFTER_WRITE_AUTO_LOAD, pipelineDataLoader);
    }

    /**
     * 没有通过@Autowired 装配，而是通过属性的set方法装配
     * @param pipelineDataLoader
     */
    public void setPipelineDataLoader(DataLoader<String, Pipeline> pipelineDataLoader) {
        this.pipelineDataLoader = pipelineDataLoader;
    }
}
