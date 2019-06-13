package com.me.service.impl;

import com.me.dto.InformCommentDto;
import com.me.mapper.MessageMapper;
import com.me.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    /**
     * 查询评论消息的信息
     * @param user_id
     * @return
     */
    @Override
    public List<InformCommentDto> selectCommentByUserId(int user_id) {

        return messageMapper.selectCommentByUserId(user_id);
    }
}
