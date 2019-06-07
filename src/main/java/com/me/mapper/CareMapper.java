package com.me.mapper;

/**
 * 操作 Care 表
 */
public interface CareMapper {
    /**
     * 根据用户 id 查询粉丝数
     * @param userId
     * @return
     */
    int selectCareByFans(int userId);

    /**
     * 根据用户 id 查询关注数
     * @param userId
     * @return
     */
    int selectCareByAttentions(int userId);
}
