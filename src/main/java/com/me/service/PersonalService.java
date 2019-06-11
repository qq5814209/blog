package com.me.service;

import com.me.dto.FavoritesDto;
import com.me.dto.UserInfoDto;
import com.me.pojo.Favorites;
import com.me.pojo.UserInfo;

import java.util.List;

public interface PersonalService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserInfoDto selectCareByAttentionsAndFans(int userId);

    /**
     * 根据用户id查询该用户的收藏夹信息
     * @param userId
     * @return
     */
    List<FavoritesDto> selectFavoritesByUserId(int userId);

    /**
     * 根据收藏夹id查询收藏夹中内容
     * @param favorites_id
     * @return
     */
    List<FavoritesDto> selectFavoritesByFavoritesId(int favorites_id);

    /**
     * 根据用户id，查询该用户关注了那些用户
     * @param user_id
     * @return
     */
    List<UserInfo> selectCareByUserId(int user_id);

    /**
     * 根据用户 id 查询该用户被那些用户关注，用于展示 fan_center.html 页面
     * @param user_id
     * @return
     */
    List<UserInfo> selectCareByUserFromId(int user_id);

    /**
     * 取消关注
     * @param user_id 关注人id
     * @param uf_id 被关注人id
     */
    void noCare(int user_id,String uf_id);

    /**
     * 关注
     * @param user_id
     * @param uf_id
     */
    void myCare(int user_id, String uf_id);

    /**
     * 更改用户头像
     * @param userInfo
     * @return
     */
    boolean updateUserInfoByUserIdToUrl(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    boolean updateUserInfo(UserInfo userInfo);


    /**
     * 添加收藏夹
     * @param favorites
     * @return
     */
    String insertFavorites(Favorites favorites);

    /**
     * 通过收藏夹id查询收藏夹信息
     * @param favoritesId
     * @return
     */
    Favorites selectFavoritesId(int favoritesId);

    /**
     * 修改收藏夹信息
     * @param favorites
     * @return
     */
    String updateFavorites(Favorites favorites);

    /**
     * 删除收藏夹
     * @param favoritesId
     * @return
     */
    boolean deleteFavorites(int favoritesId);
}
