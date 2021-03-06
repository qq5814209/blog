package com.me.mapper;

import com.me.dto.InformCareDto;
import com.me.dto.InformCommentDto;
import com.me.dto.InformPraiseDto;
import com.me.dto.InformSystemDto;

import java.util.List;

public interface MessageMapper {

    /**
     * 查询评论消息的信息
     *
     * @param user_id
     * @return
     */
    List<InformCommentDto> selectCommentByUserId(int user_id);

    /**
     * 根据评论消息 id 删除评论消息
     *
     * @param informComment_id
     * @return
     */
    int deleteInformByInformComment_id(int informComment_id);

    /**
     * 把未读消息修改为已读
     *
     * @param informComment_id
     */
    int updateInformToReadingByInformCommentId(int informComment_id);

    /**
     * 清除所有评论消息
     *
     * @param user_id
     * @return
     */
    int deleteInformCommentByUserIdAndAll(int user_id);

    /**
     * 查询所有关注信息
     * @param user_id
     * @return
     */
    List<InformCareDto> selectCareByUserId(int user_id);

    /**
     * 根据关注消息id删除关注消息
     * @param informCare_id
     * @return
     */
    int deleteInformByInformCare_id(int informCare_id);

    /**
     * 清除所有关注消息
     * @param user_id
     * @return
     */
    int deleteInformCareByUserIdAndAll(int user_id);

    /**
     * 查询所有点赞消息
     * @param user_id
     * @return
     */
    List<InformPraiseDto> selectInformPraiseByUserId(int user_id);

    /**
     * 把未读的点赞消息修改为已读
     * @param informPraiseId
     */
    void updateInformToReadingByInformPraiseId(int informPraiseId);

    /**
     * 把未读的点赞消息全部修改为已读
     * @param user_id
     */
    int updateInformToReadingByAll(int user_id);

    /**
     * 根据点赞消息id清除点赞消息
     * @param informPraise_id
     * @return
     */
    int deleteInformByInformPraise_id(int informPraise_id);

    /**
     * 删除所有点赞消息
     * @param user_id
     * @return
     */
    int deleteInformPraiseByUserIdAndAll(int user_id);

    /**
     * 查询所有系统消息
     * @param user_id
     * @return
     */
    List<InformSystemDto> selectInformSystemByUserId(int user_id);

    /**
     * 把未读的系统消息修改为已读
     * @param informSystem_id
     */
    void updateInformToReadingByInformSystemId(int informSystem_id);

    /**
     * 把未读的系统消息全部变成已读
     * @return
     */
    int updateInformSystemToReadingByAll(int user_id);

    /**
     * 根据系统消息id删除系统消息
     * @param informSystem_id
     * @return
     */
    int deleteInformByInformSystem_id(int informSystem_id);

    /**
     * 删除所有系统消息
     * @param user_id
     * @return
     */
    int deleteInformSystemByUserIdAndAll(int user_id);
}
