package com.hacker.framework.repository.dao;

import com.hacker.framework.repository.DO.GdfSequenceDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hacker on 2019/4/15 0015-下午 11:22
 *
 * @desc
 */
public interface GdfSequenceDAO {

    int updateSequenceValue(@Param("name") String name, @Param("newValue") String newValue,
                            @Param("oldValue") String oldValue);

    GdfSequenceDO queryByName(String name);
}
