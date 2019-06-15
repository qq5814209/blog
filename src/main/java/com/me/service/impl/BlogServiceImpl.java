package com.me.service.impl;

import com.me.dto.*;
import com.me.mapper.BlogMapper;
import com.me.pojo.Comment;
import com.me.pojo.UserInfo;
import com.me.service.BlogService;

import com.me.vo.ReportVo;

import com.me.vo.ShowVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    public List<ClassificationDto> findClass(int userId) {
        List<ClassificationDto> mapperClass = blogMapper.findClass(userId);
        return mapperClass;
    }

    public List<BlogNumDto> findBlogNum(int userId) {
        List<BlogNumDto> blogNumDtoList =blogMapper.findBlogNum(userId);
        return blogNumDtoList;
    }

    public List<BlogDto> showBlog(int userId) {
        List<BlogDto> blogDtoList = blogMapper.showBlog(userId);
        return blogDtoList;
    }

    public List<BlogDto> showBlogByTime(BlogNumDto blogNumDto) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByTime(blogNumDto);
        return blogDtoList;
    }

    public List<BlogDto> showBlogByClassId(ClassificationDto classificationDto) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByClassId(classificationDto);
        return blogDtoList;
    }

    public List<CommentDto> findComment(int userId) {
        List<CommentDto> commentDtoList =  blogMapper.findComment(userId);
        return commentDtoList;
    }

    public List<BlogDto> showArticle(BlogDto blogDto) {
        List<BlogDto> blogDtoList = blogMapper.showArticle(blogDto);
        return blogDtoList;
    }

    public List<BlogDto> showBlogByNewTime(int userId) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByNewTime(userId);
        return blogDtoList;
    }

    @Override
    public List<BlogDto> showBlogByCommentNum(int userId) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByCommentNum(userId);
        return blogDtoList;
    }

    @Override
    public UserInfo showCommentBox(int loginUserId) {
        UserInfo userInfo = blogMapper.showCommentBox(loginUserId);
        return userInfo;
    }

    @Override
    public int addComment(Comment comment) {
        int num = blogMapper.addComment(comment);
        return num;
    }

    @Override
    public UserDto findUserDto(int userId) {
        UserDto userDto = blogMapper.findUserDto(userId);
        return userDto;
    }


    @Override
    public List<Comment> showCommentByBlogId(int blogId) {
        List<Comment> commentList = blogMapper.showCommentByBlogId(blogId);
        return commentList;
    }
    /**
     * 添加举报信息
     * @param reportVo
     * @return
     */
    @Override
    public boolean insertReportMessage(ReportVo reportVo) {

        return blogMapper.insertReportMessage(reportVo) > 0;
    }
    /*
     * 点赞
     * */
    @Override
    public int getPraise(ShowVo showVo) {
        //根据user_id and blog_id查询有无赞记录
        ShowDto showDto = blogMapper.selectPraise1(showVo);
        int status;
        //showDto不为空，就有赞记录
        if(showDto != null) {
            //获取赞记录的状态
            status = showDto.getStatus();
            //状态为1的时候设置为0,删除赞
            if(status == 1) {
                showVo.setStatus(0);
                int i = blogMapper.xiuGaiPraise(showVo);
                return i;//i为取消点赞

                //状态为0的时候设置为1,点赞
            }else if(status == 0) {
                showVo.setStatus(1);
                int i = blogMapper.xiuGaiPraise(showVo);
                return i+1;
            }
        }
        //showDto为空，插入赞记录,并设置状态为1,点赞
        int i = blogMapper.getPraise(showVo);
        return i+1;//i为2点赞
    }

    /*
     * 根据user_id和blog_id查询点赞记录
     * */
    @Override
    public ShowDto selectPraise1(ShowVo showVo) {
        ShowDto showDto = blogMapper.selectPraise1(showVo);
        return showDto;
    }

    /*
     * 通过修改状态字来点赞或者取消赞
     * */
    @Override
    public int xiuGaiPraise(ShowVo showVo) {
        int count = blogMapper.xiuGaiPraise(showVo);
        return count;
    }

    /*
     * 根据博客id查询此博客的赞的数量
     * */
    @Override
    public ShowDto selectPraise2(ShowVo showVo) {
        ShowDto showDto = blogMapper.selectPraise2(showVo);
        return showDto;
    }

    /*
     * 根据博客id查询此篇浏览量browse_number
     * */
//    @Override
//    public ShowDto getBrowse(ShowVo showVo) {
//        ShowDto showDto = blogMapper.getBrowse(showVo);
//        ShowDto showDto1 = blogMapper.selectBrowse(showVo);
//        if(showDto1 == null) {
//            int i = blogMapper.addBrowse(showVo);
//        }
//
//        return showDto;
//    }

    /*
     * 根据user_id和blog_id增加浏览量
     * */
    @Transactional
    @Override
    public int addBrowse(ShowVo showVo) {
        ShowDto showDto = blogMapper.selectBrowse(showVo);
        int i = 0;
        if(showDto == null) {
            i = blogMapper.addBrowse(showVo);
    }

        return i;
    }

    /*
     * 查询相应blog_id和user_id的浏览记录
     * */
    @Override
    public ShowDto selectBrowse(ShowVo showVo) {
        ShowDto showDto = blogMapper.selectBrowse(showVo);
        return showDto;

    }

    @Override
    public int addSpan(int blogId) {
        int num = blogMapper.addSpan(blogId);
        return num;
    }

}
