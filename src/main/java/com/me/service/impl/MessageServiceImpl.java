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
     *
     * @param user_id
     * @return
     */
    @Override
    public List<InformCommentDto> selectCommentByUserId(int user_id) {

        return messageMapper.selectCommentByUserId(user_id);
    }

    /**
     * 根据评论消息 id 删除评论消息
     *
     * @param informComment_id
     * @return
     */
    @Override
    public boolean deleteInformByInformComment_id(int informComment_id) {

        return messageMapper.deleteInformByInformComment_id(informComment_id) > 0;
    }

    /**
     * 把未读消息修改为已读
     *
     * @param informComment_id
     */
    @Override
    public void updateInformToReadingByInformCommentId(int informComment_id) {
        messageMapper.updateInformToReadingByInformCommentId(informComment_id);
    }

    /**
     * 清除所有评论消息
     *
     * @param user_id
     * @return
     */
    @Override
    public boolean deleteInformByUserIdAndAll(int user_id) {

        return messageMapper.deleteInformByUserIdAndAll(user_id) > 0;
    }
}
