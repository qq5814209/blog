package com.me.service;


import com.me.pojo.BlogInfo;
import com.me.vo.FavoritesVo;

import java.util.List;

/**
 * 查询收藏夹信息，修改收藏夹信息
 */
public interface FavoritesService {
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
