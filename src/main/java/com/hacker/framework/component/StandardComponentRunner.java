package com.hacker.framework.component;

import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.enums.ComTplTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class StandardComponentRunner implements ComponentRunner{

    @Autowired
    private ComConfigContainer comConfigContainer;

    @Override
    public Object runComponent(String comCode, PipelineContext pipelineContext) {
        //是否跳过某些组件
        boolean skip = false;

        if (pipelineContext.isComplete()){
            skip = true;
        }

        MetaComConfig metaComConfig = comConfigContainer.getMetaComConfig(comCode);

        //pipeline 完成是否调用写缓存的逻辑放到写缓存组件里去判断,这里主要判断 CommonQueryResult 是否从缓存中读取的
        if (ComTplTypeEnum.CACHE_WRITE.getType().equals(metaComConfig.getComTplType())){
            skip = false;
        }

        if (!skip){
            //公共的组件模板，由具体的实现类完成功能
            CommonComTemplate component = ComponentContainer.getComponent(metaComConfig.getComTplType());
            component.run(metaComConfig, pipelineContext);
        }
        return null;
    }
}
