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
    public List<ShowDto> showComment(ShowVo showVo);
    public List<ShowDto> showMyComment(ShowVo showVo);
    public boolean delComment(ShowVo showVo);
    public List<ShowDto> getAllBigType();
    public List<ShowDto> getAllBlogs(ShowVo showVo);
    public List<ShowDto> searchMyBlogs(ShowVo showVo);



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
    List<Person_TypeDto> selectPersonType(int user_id);

    /**
     * 查询博客类型
     * @return
     */
    List<Blog_TypeDto> selectBlogType();



}
