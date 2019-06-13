package com.me.mapper;

import com.me.dto.BlogDto;
import com.me.dto.BlogNumDto;
import com.me.dto.ClassificationDto;

import java.util.List;

public interface BlogMapper {


    List<ClassificationDto> findClass(int userId);

    List<BlogNumDto> findBlogNum(int userId);

    List<BlogDto> showBlog(int userId);

    List<BlogDto> showBlogByTime(BlogNumDto blogNumDto);

    List<BlogDto> showBlogByClassId(ClassificationDto classificationDto);
}
