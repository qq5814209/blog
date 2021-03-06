package com.me.mapper;

import com.me.dto.SumDto;
import com.me.dto.UserInfoDto;
import com.me.pojo.Favorites;
import com.me.pojo.UserInfo;
import com.me.dto.FavoritesDto;
import com.me.vo.CareVo;
import com.me.vo.UserInfoVo;

import java.util.List;

public interface PersonalMapper {

    /**
     * 根据用户 id 查询用户信息
     * @param userId
     * @return
     */
    UserInfo selectUserInfo(int userId);

    /**
     * 根据用户id查询该用户的收藏夹信息
     * @param userId
     * @return
     */
    List<Favorites> selectFavoritesByUserId(int userId);

    /**
     * 根据收藏夹id查询收藏夹中放了几条收藏
     * @param favorites_id
     * @return
     */
    int selectFavoritesCollectByFavoritesId(int favorites_id);

    /**
     * 根据收藏夹id查询收藏夹中博客的内容
     * @param favorites_id
     * @return
     */
    List<FavoritesDto> selectFavoritesByFavoritesId(int favorites_id);

    /**
     * 根据用户 id 查询个人信息，其中包括粉丝数、关注数、用户的个人信息
     * @param userId
     * @return
     */
    UserInfoDto selectUserInfoAndAttentionsAndFans(int userId);

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
     * @param careVo
     */
    void noCare(CareVo careVo);

    /**
     * 关注
     * @param careVo
     */
    void myCare(CareVo careVo);

    /**
     * 更改用户头像
     * @param userInfo
     * @return
     */
    int updateUserInfoByUserIdToUrl(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 添加收藏夹
     * @param favorites
     * @return
     */
    int insertFavorites(Favorites favorites);

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
    int updateFavorites(Favorites favorites);

    /**
     * 删除收藏夹
     * @param favoritesId
     * @return
     */
    int deleteFavorites(int favoritesId);

    /**
     * 根据用户id统计各种信息总数量
     * @param user_id
     * @return
     */
    SumDto selectCount(int user_id);
}
