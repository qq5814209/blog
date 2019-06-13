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
//    public List<ShowDto> searchBlogs(String str);
    public List<ShowDto> getBlogsByUserId(ShowVo showVo);

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


}
