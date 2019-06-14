package com.me.mapper;

import com.me.vo.LevelValueVo;

public interface LevelValueMapper {

    /**
     * 增加经验值
     * @param levelValueVo
     */
    int addValue(LevelValueVo levelValueVo);
}
