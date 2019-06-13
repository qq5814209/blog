package com.me.service.impl;

import com.me.dto.InformCareDto;
import com.me.dto.InformCommentDto;
import com.me.dto.InformPraiseDto;
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
    public boolean deleteInformCommentByUserIdAndAll(int user_id) {

        return messageMapper.deleteInformCommentByUserIdAndAll(user_id) > 0;
    }

    /**
     * 查询所有关注信息
     * @param user_id
     * @return
     */
    @Override
    public List<InformCareDto> selectCareByUserId(int user_id) {

        return messageMapper.selectCareByUserId(user_id);
    }

    /**
     * 根据关注消息id删除关注消息
     * @param informCare_id
     * @return
     */
    @Override
    public boolean deleteInformByInformCare_id(int informCare_id) {

        return messageMapper.deleteInformByInformCare_id(informCare_id) > 0;
    }

    /**
     * 清除所有关注消息
     * @param user_id
     * @return
     */
    @Override
    public boolean deleteInformCareByUserIdAndAll(int user_id) {
        return messageMapper.deleteInformCareByUserIdAndAll(user_id) > 0;
    }

    /**
     * 查询所有点赞消息
     * @param user_id
     * @return
     */
    @Override
    public List<InformPraiseDto> selectInformPraiseByUserId(int user_id) {

        return messageMapper.selectInformPraiseByUserId(user_id);
    }

    /**
     * 把未读的点赞消息修改为已读
     * @param informPraiseId
     */
    @Override
    public void updateInformToReadingByInformPraiseId(int informPraiseId) {
        messageMapper.updateInformToReadingByInformPraiseId(informPraiseId);
    }

    /**
     * 把未读的点赞消息全部修改为已读
     * @param user_id
     */
    @Override
    public boolean updateInformToReadingByAll(int user_id) {
        return messageMapper.updateInformToReadingByAll(user_id) > 0;
    }

    /**
     * 根据点赞消息id清除点赞消息
     * @param informPraise_id
     * @return
     */
    @Override
    public boolean deleteInformByInformPraise_id(int informPraise_id) {
        return messageMapper.deleteInformByInformPraise_id(informPraise_id) > 0;
    }

    /**
     * 删除所有点赞消息
     * @param user_id
     * @return
     */
    @Override
    public boolean deleteInformPraiseByUserIdAndAll(int user_id) {
        return messageMapper.deleteInformPraiseByUserIdAndAll(user_id) > 0;
    }
}
