package com.me.service;

import com.me.dto.ShowDto;
import com.me.vo.ShowVo;

import java.util.List;

public interface InquireService {
    public List<ShowDto> getBlogsByTypeName(ShowVo showVo);
    public boolean addPersonalCategory(ShowVo showVo);
    public List<ShowDto> allPersonalCategory(ShowVo showVo);
    public boolean deletePersonalCategory(ShowVo showvo);
    public boolean updatePersonalCategory(ShowVo showvo);
    public List<ShowDto> searchBlogs(ShowVo showvo);
    public boolean deleteBlogbyBlog_id(ShowVo showVo);
    public List<ShowDto> getBlogsByUserId(ShowVo showVo);
}
