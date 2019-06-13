package com.me.mapper;

import com.me.dto.ShowDto;
import com.me.vo.ShowVo;
import com.me.vo.WriteBlogVo;

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

    /**
     * 写博客
     * @param writeBlogVo
     * @return
     */
    int writeBlog(WriteBlogVo writeBlogVo);

    /**
     * 获取最新的博客id
     */
    int selectMaxBlog_id();

    /**
     * 用户_博客中间表插入数据
     * @param writeBlogVo
     * @return
     */
    int insertUser_Blog(WriteBlogVo writeBlogVo);
}
