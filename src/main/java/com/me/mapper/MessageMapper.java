package com.me.mapper;

import com.me.dto.InformCommentDto;

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
    int deleteInformByUserIdAndAll(int user_id);
}
