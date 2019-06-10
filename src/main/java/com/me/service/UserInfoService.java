package com.me.service;

import com.me.pojo.UserInfo;
import com.me.vo.FavoritesVo;
import com.me.vo.UserInfoVo;

import java.util.List;

/**
 * 查询用户信息、修改用户信息用
 */
public interface UserInfoService {

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */
    UserInfo login(String user, String password);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserInfoVo selectUserInfo(int userId);

    /**
     * 根据用户id查询该用户的收藏夹信息
     * @param userId
     * @return
     */
    List<FavoritesVo> selectFavoritesByUserId(int userId);

    /**
     * 根据收藏夹id查询收藏夹中内容
     * @param favorites_id
     * @return
     */
    List<FavoritesVo> selectFavoritesByFavoritesId(int favorites_id);
}
