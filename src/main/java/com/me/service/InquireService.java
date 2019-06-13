package com.me.service;

import com.me.dto.Blog_TypeDto;
import com.me.dto.Person_TypeDto;
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
<<<<<<< HEAD
    public List<ShowDto> showMyComment(ShowVo showVo);
    public boolean delComment(ShowVo showVo);
=======

    /**
     * 写博客
     * @param user_id
     * @param txtTitle
     * @param content
     * @param blogType
     * @return
     */
    int writeBlog(int user_id, String txtTitle, String content,String typeSpan,String blogType);

    /**
     * 查询个人分类类型
     * @return
     */
    List<Person_TypeDto> selectPersonType();

    /**
     * 查询博客类型
     * @return
     */
    List<Blog_TypeDto> selectBlogType();


>>>>>>> ed08ecc593e8420e0833c40d3cce59ab674d35dd
}
