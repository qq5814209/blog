package com.me.mapper;

import com.me.dto.InformCommentDto;

import java.util.List;

public interface MessageMapper {

    /**
     * 查询评论消息的信息
     * @param user_id
     * @return
     */
    List<InformCommentDto> selectCommentByUserId(int user_id);

}
