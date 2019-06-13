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
        List<InformCommentDto> informCommentDtoList = messageService.selectCommentByUserId(userInfo.getUser_id());
        return informCommentDtoList;
    }
}
