package com.me.mapper;

import com.me.dto.UserInfoDto;
import com.me.pojo.Favorites;
import com.me.pojo.UserInfo;
import com.me.dto.FavoritesDto;

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
     * 根据用户 id 查询粉丝数
     * @param userId
     * @return
     */
    UserInfoDto selectCareByAttentionsAndFans(int userId);

    /**
     * 根据用户 id 查询关注数
     * @param userId
     * @return
     */
//    int selectCareByAttentions(int userId);

}
