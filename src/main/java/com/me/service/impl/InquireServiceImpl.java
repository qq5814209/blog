package com.me.service.impl;

import com.me.dto.Blog_TypeDto;
import com.me.dto.Person_TypeDto;
import com.me.dto.ShowDto;
import com.me.mapper.InquireMapper;
import com.me.mapper.LevelValueMapper;
import com.me.service.InquireService;
import com.me.vo.LevelValueVo;
import com.me.vo.ShowVo;
import com.me.vo.WriteBlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InquireServiceImpl implements InquireService{

    @Autowired
    InquireMapper inquireMapper;

    @Autowired
    LevelValueMapper levelValueMapper;


    public List<ShowDto> getBlogsByTypeName(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.getBlogsByTypeName(showVo);
        for(ShowDto showDto : showDtos){
            String str = showDto.getBlog_content().substring(0,5);
            System.out.println(showDto);
            showDto.setBlog_content(str);
        }
        return showDtos;
    }

    @Transactional
    public boolean addPersonalCategory(ShowVo showVo) {
        System.out.println("1232312+");
        int count = inquireMapper.addPersonalCategory(showVo);
        System.out.println("count++++++++++"+count);
        if(count>0) {
            return true;
        }else{
            return false;
        }

    }

    public List<ShowDto> allPersonalCategory(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.allPersonalCategory(showVo);
        return showDtos;
    }

    @Transactional
    public boolean deletePersonalCategory(ShowVo showvo) {
        int count = inquireMapper.deletePersonalCategory(showvo);
        if(count>0) {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updatePersonalCategory(ShowVo showvo) {
        int count = inquireMapper.updatePersonalCategory(showvo);

        if(count>0) {
            return true;
        }
        return false;
    }


    public List<ShowDto> searchBlogs(ShowVo showvo) {
        showvo.setBlog_content("%"+showvo.getType_name()+"%");
        showvo.setBlog_title("%"+showvo.getType_name()+"%");
        List<ShowDto> showDtos = inquireMapper.searchBlogs(showvo);
        for(ShowDto showDto : showDtos){
            String str = showDto.getBlog_content().substring(0,5);
            showDto.setBlog_content(str);
        }
        return showDtos;
    }

    @Transactional
    public boolean deleteBlogbyBlog_id(ShowVo showVo) {
        int count = inquireMapper.deleteBlogbyBlog_id(showVo);
        if(count>0) {
            return true;
        }
        return false;
    }


    public List<ShowDto> getBlogsByUserId(ShowVo showVo) {

        int user_id = showVo.getUser_id();
        List<ShowDto> showDtos = inquireMapper.getBlogsByUserId(showVo);
        for(ShowDto showDto : showDtos){
            String str = showDto.getBlog_content().substring(0,5);
            showDto.setBlog_content(str);
            showDto.setUser_id(user_id);
        }
        return showDtos;
    }

    public List<ShowDto> showMyComment(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.showMyComment(showVo);
        return showDtos;
    }


    @Transactional
    public boolean delComment(ShowVo showVo) {
        int count = inquireMapper.delComment(showVo);
        if(count>0) {
            return true;
        }
        return false;
    }

    @Override
    public List<ShowDto> getAllBigType() {
        List<ShowDto> showDtos = inquireMapper.getAllBigType();
        return showDtos;
    }


    /**
     * 写博客
     * @param user_id
     * @param txtTitle
     * @param content
     * @param blogType
     * @return
     */
    @Override
    public int writeBlog(int user_id, String txtTitle, String content,String typeSpan,String blogType) {
        WriteBlogVo writeBlogVo = new WriteBlogVo();
        writeBlogVo.setUser_id(user_id);
        writeBlogVo.setTxtTitle(txtTitle);
        writeBlogVo.setContent(content);
        writeBlogVo.setBlogType(blogType);

        //判断新增分类是否已存在
        String persontype_id = inquireMapper.isExist(typeSpan);
        //如果已存在
        if(persontype_id != null){
            System.out.println(persontype_id + "一");
            writeBlogVo.setTypeSpan(persontype_id);
            System.out.println(writeBlogVo.getTypeSpan() + "二");
        }
        //如果不存在
        else {
            WriteBlogVo writeBlogVo2 = new WriteBlogVo();
            writeBlogVo2.setUser_id(user_id);
            writeBlogVo2.setTypeSpan(typeSpan);
            //把新增的分类插入个人分类表
            inquireMapper.insertPerson_Type(writeBlogVo2);
            //查询出刚刚插入最新的分类id
            String newPt_id  = inquireMapper.getPt_Id();
            System.out.println(newPt_id + "三");
            writeBlogVo.setTypeSpan(newPt_id);
        }
        
        //1、博客内容表插入数据
        int i1 = inquireMapper.writeBlog(writeBlogVo);
        System.out.println(i1 + "11111");
        //2、获取最新插入的博客id
        int blog_id = inquireMapper.selectMaxBlog_id();
        System.out.println(blog_id);
        writeBlogVo.setBlog_id(blog_id);
        //3、用户_博客中间表插入数据
        int i2 = inquireMapper.insertUser_Blog(writeBlogVo);
        System.out.println(i2 + "22222");
        //4、博客分类_个人分类中间表插入数据
        int i3 = inquireMapper.insertPbt_Middle(writeBlogVo);
        System.out.println(i3 + "33333");
        //5、增加经验值
        LevelValueVo levelValueVo = new LevelValueVo();
        levelValueVo.setUser_id(user_id);
        levelValueVo.setValue(50);
        int i4 = levelValueMapper.addValue(levelValueVo);
        System.out.println(i4 + "44444");

        //成功
        if(i1 == 1 && i2 == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 查询个人分类类型
     * @return
     */
    @Override
    public List<Person_TypeDto> selectPersonType(int user_id) {
        return inquireMapper.selectPersonType(user_id);
    }

    /**
     * 查询博客类型
     * @return
     */
    @Override
    public List<Blog_TypeDto> selectBlogType() {
        return inquireMapper.selectBlogType();
    }


}
