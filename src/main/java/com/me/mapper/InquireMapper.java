package com.me.mapper;

import com.me.dto.Blog_TypeDto;
import com.me.dto.Person_TypeDto;
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
    public int deleteBlogbyBlog_id(ShowVo showVo);
    public List<ShowDto> getBlogsByUserId(ShowVo showVo);
    public List<ShowDto> showComment(ShowVo showVo);
    public List<ShowDto> showMyComment(ShowVo showVo);
    public int delComment(ShowVo showVo);
    public List<ShowDto> getAllBigType();
    public List<ShowDto> getAllBlogs(ShowVo showVo);
    public List<ShowDto> searchMyBlogs(ShowVo showVo);

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

    /**
     * 判断新增分类是否已存在
     * @param typeSpan
     * @return
     */
    String isExist(String typeSpan);

    /**
     * 新增分类插入分类表
     * @param writeBlogVo2
     */
    void insertPerson_Type(WriteBlogVo writeBlogVo2);

    /**
     * 获取新增分类的id
     * @return
     */
    String getPt_Id();


    /**
     * 博客分类_个人分类中间表插入数据
     * @param writeBlogVo
     * @return
     */
    int insertPbt_Middle(WriteBlogVo writeBlogVo);

}
