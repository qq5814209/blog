package com.me.service;

import com.me.dto.FavoritesDto;
import com.me.dto.UserInfoDto;

import java.util.List;

public interface PersonalService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserInfoDto selectUserInfo(int userId);

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
}
