package com.me.service.impl;

import com.me.mapper.LevelValueMapper;
import com.me.service.LevelValue;
import com.me.vo.LevelValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelValueImpl implements LevelValue {

    @Autowired
    private LevelValueMapper levelValueMapper;

    /**
     * 增加经验值
     * @param user_id
     * @param value
     */
    public void addValue(int user_id, int value) {
        LevelValueVo levelValueVo = new LevelValueVo();
        levelValueVo.setUser_id(user_id);
        levelValueVo.setValue(value);
        levelValueMapper.addValue(levelValueVo);
    }
}
