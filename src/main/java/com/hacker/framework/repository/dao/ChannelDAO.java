package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.ChannelDO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public interface ChannelDAO {

    /**
     * 插入数据库（现在是都是sql语句手动插入的，后面会单独做一个web服务，通过页面配置实现）
     * @param channelDO
     * @return
     */
    int insert(ChannelDO channelDO);

    /**
     * 通过渠道编码获取渠道信息
     * @param channelCode
     * @return
     */
    ChannelDO getChannelByCode(String channelCode);

    /**
     * 通过渠道编码的集合获取多个渠道对象
     * @param codeList
     * @return
     */
    List<ChannelDO> getChannelsByCodeList(@Param("codeList") List<String> codeList);

    /**
     * 返回map，并通过@MapKey() 注解指定key
     * @param codeList
     * @return
     */
    @MapKey("channelCode")
    Map<String, ChannelDO> getChannelMapByCodeList(@Param("codeList") List<String> codeList);

    /**
     * 删除
     * @param channelCode
     * @return
     */
    int deleteByCode(String channelCode);
}
