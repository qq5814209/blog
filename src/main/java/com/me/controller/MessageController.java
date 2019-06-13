package com.me.controller;

import com.me.dto.InformCareDto;
import com.me.dto.InformCommentDto;
import com.me.dto.InformPraiseDto;
import com.me.pojo.UserInfo;
import com.me.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用于消息页面的controller
 */
@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    /**
     * 查询评论消息的信息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectInformCommentByUserId", method = RequestMethod.GET)
    public Object selectCommentByUserId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return messageService.selectCommentByUserId(userInfo.getUser_id());
    }

    /**
     * 根据评论消息 id 删除评论消息
     * @param informComment_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformByInformComment_id", method = RequestMethod.POST)
    public Object deleteInformByInformComment_id(int informComment_id){
        return messageService.deleteInformByInformComment_id(informComment_id);
    }

    /**
     * 把未读的评论消息修改为已读
     * @param informComment_id
     */
    @ResponseBody
    @RequestMapping(value = "/updateInformToReadingByInformCommentId", method = RequestMethod.POST)
    public void updateInformToReadingByInformCommentId(int informComment_id){
        messageService.updateInformToReadingByInformCommentId(informComment_id);
    }

    /**
     * 清除所有评论消息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformCommentByUserIdAndAll", method = RequestMethod.POST)
    public Object deleteInformByUserIdAndAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return messageService.deleteInformCommentByUserIdAndAll(userInfo.getUser_id());
    }

    /**
     * 查询所有关注信息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectInformCareByUserId", method = RequestMethod.GET)
    public Object selectCareByUserId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return messageService.selectCareByUserId(userInfo.getUser_id());
    }

    /**
     * 根据关注消息id删除关注消息
     * @param informCare_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformByInformCare_id", method = RequestMethod.POST)
    public Object deleteInformByInformCare_id(int informCare_id){
        return messageService.deleteInformByInformCare_id(informCare_id);
    }

    /**
     * 清除所有关注消息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformCareByUserIdAndAll", method = RequestMethod.POST)
    public Object deleteInformCareByUserIdAndAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return messageService.deleteInformCareByUserIdAndAll(userInfo.getUser_id());
    }

    /**
     * 查询所有点赞消息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectInformPraiseByUserId", method = RequestMethod.GET)
    public Object selectInformPraiseByUserId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return messageService.selectInformPraiseByUserId(userInfo.getUser_id());
    }

    /**
     * 把未读的点赞消息修改为已读
     * @param informPraise_id
     */
    @ResponseBody
    @RequestMapping(value = "/updateInformToReadingByInformPraiseId", method = RequestMethod.POST)
    public void updateInformToReadingByInformPraiseId(int informPraise_id){
        messageService.updateInformToReadingByInformPraiseId(informPraise_id);
    }

    /**
     * 把未读的点赞消息全部修改为已读
     * @param session
     */
    @ResponseBody
    @RequestMapping(value = "/updateInformToReadingByAll", method = RequestMethod.POST)
    public Object updateInformToReadingByAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        boolean n = messageService.updateInformToReadingByAll(userInfo.getUser_id());
        return n;
    }

    /**
     * 根据点赞消息id清除点赞消息
     * @param informPraise_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformByInformPraise_id",method = RequestMethod.POST)
    public Object deleteInformByInformPraise_id(int informPraise_id){
        return messageService.deleteInformByInformPraise_id(informPraise_id);
    }

    /**
     * 删除所有点赞消息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformPraiseByUserIdAndAll", method = RequestMethod.POST)
    public Object deleteInformPraiseByUserIdAndAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        return messageService.deleteInformPraiseByUserIdAndAll(userInfo.getUser_id());
    }
}






















