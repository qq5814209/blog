package com.me.controller;

import com.me.dto.InformCommentDto;
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
    @RequestMapping(value = "/selectCommentByUserId", method = RequestMethod.GET)
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
     * 把未读消息修改为已读
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
    @RequestMapping(value = "/deleteInformByUserIdAndAll", method = RequestMethod.POST)
    public Object deleteInformByUserIdAndAll(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return messageService.deleteInformByUserIdAndAll(userInfo.getUser_id());
    }
}






















