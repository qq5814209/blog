package com.me.mapper;

import com.me.dto.ShowDto;
import com.me.vo.ShowVo;

import java.util.List;

public interface InquireMapper {
    public List<ShowDto> getBlogsByTypeName(ShowVo showVo);
    public int addPersonalCategory(ShowVo showVo);
    public List<ShowDto> allPersonalCategory(ShowVo showVo);
    public int deletePersonalCategory(ShowVo showvo);
    public int updatePersonalCategory(ShowVo showvo);
    public List<ShowDto> searchBlogs(ShowVo showvo);
//    public List<ShowDto> searchBlogs(String str);
    public List<ShowDto> getBlogsByUserId(ShowVo showVo);
}
