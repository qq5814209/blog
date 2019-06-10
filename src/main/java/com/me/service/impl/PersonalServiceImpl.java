package com.me.service.impl;

import com.me.mapper.PersonalMapper;
import com.me.pojo.Favorites;
import com.me.pojo.UserInfo;
import com.me.service.PersonalService;
import com.me.dto.FavoritesDto;
import com.me.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    PersonalMapper personalMapper;

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    public UserInfoDto selectCareByAttentionsAndFans(int userId) {

        UserInfoDto userInfoDto = personalMapper.selectCareByAttentionsAndFans(userId);

        return userInfoDto;
    }

    /**
     * 根据用户id查询该用户的收藏夹信息
     * @param userId
     * @return
     */
    public List<FavoritesDto> selectFavoritesByUserId(int userId) {
        List<Favorites> favoritesList = personalMapper.selectFavoritesByUserId(userId);
        List<FavoritesDto> favoritesVoList = new ArrayList<FavoritesDto>();

        for (Favorites favorites : favoritesList) {
            FavoritesDto favoritesVo = new FavoritesDto();
            int favorites_id = favorites.getFavorites_id();
            int contents = personalMapper.selectFavoritesCollectByFavoritesId(favorites_id);
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
    public List<FavoritesDto> selectFavoritesByFavoritesId(int favorites_id) {

        return personalMapper.selectFavoritesByFavoritesId(favorites_id);
    }
}
