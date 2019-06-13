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
    public int deleteBlogbyBlog_id(ShowVo showVo);
    public List<ShowDto> getBlogsByUserId(ShowVo showVo);
    public List<ShowDto> showMyComment(ShowVo showVo);
    public int delComment(ShowVo showVo);

}
