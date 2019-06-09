package com.me.service.impl;

import com.me.mapper.FavoritesMapper;
import com.me.pojo.BlogInfo;
import com.me.pojo.Favorites;
import com.me.service.FavoritesService;
import com.me.vo.FavoritesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询收藏夹信息，修改收藏夹信息
 */
@Service
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    FavoritesMapper favoritesMapper;

    /**
     * 根据用户id查询该用户的收藏夹信息
     * @param userId
     * @return
     */
    public List<FavoritesVo> selectFavoritesByUserId(int userId) {
        List<Favorites> favoritesList = favoritesMapper.selectFavoritesByUserId(userId);
        List<FavoritesVo> favoritesVoList = new ArrayList<FavoritesVo>();

        for (Favorites favorites : favoritesList) {
            FavoritesVo favoritesVo = new FavoritesVo();
            int favorites_id = favorites.getFavorites_id();
            int contents = favoritesMapper.selectFavoritesCollectByFavoritesId(favorites_id);
//            int attentions = favoritesMapper.selectCareFavoritesByFavoritesId();   因获取关注该收藏夹的方法未想清楚，故注释

            favoritesVo.setFavorites(favorites);
            favoritesVo.setContents(contents);
//            favoritesVo.setAttentions(attentions);    默认为零关注数
            favoritesVoList.add(favoritesVo);

        }

        return favoritesVoList;
    }

    /**
     * 根据收藏夹id查询收藏夹中内容
     * @param favorites_id
     * @return
     */
    public List<FavoritesVo> selectFavoritesByFavoritesId(int favorites_id) {

        return favoritesMapper.selectFavoritesByFavoritesId(favorites_id);
    }
}
