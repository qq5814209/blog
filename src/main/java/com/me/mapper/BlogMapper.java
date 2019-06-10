package com.me.mapper;

import com.me.dto.ClassificationDto;

import java.util.List;

public interface BlogMapper {

    /**
     *  查询用户博客的所有分类
     * @return
     */
    List<ClassificationDto> findClass();
}
