package com.me.service.impl;

import com.me.mapper.PersonalMapper;
import com.me.pojo.Favorites;
import com.me.pojo.UserInfo;
import com.me.service.PersonalService;
import com.me.dto.FavoritesDto;
import com.me.dto.UserInfoDto;
import com.me.vo.CareVo;
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

    /**
     * 根据用户id，查询该用户关注了那些用户
     * @param user_id
     * @return
     */
    public List<UserInfo> selectCareByUserId(int user_id) {

        return personalMapper.selectCareByUserId(user_id);
    }

    /**
     * 根据用户 id 查询该用户被那些用户关注，用于展示 fan_center.html 页面
     * @param user_id
     * @return
     */
    public List<UserInfo> selectCareByUserFromId(int user_id) {

        return personalMapper.selectCareByUserFromId(user_id);
    }

    /**
     * 取消关注
     * @param user_id 关注人id
     * @param uf_id 被关注人id
     */
    public void noCare(int user_id, String uf_id) {
        CareVo careVo = new CareVo();
        careVo.setUt_id(user_id);
        careVo.setUf_id(Integer.parseInt(uf_id));
        personalMapper.noCare(careVo);
    }

    /**
     * 关注
     * @param user_id
     * @param uf_id
     */
    public void myCare(int user_id, String uf_id) {
        CareVo careVo = new CareVo();
        careVo.setUt_id(user_id);
        careVo.setUf_id(Integer.parseInt(uf_id));
        personalMapper.myCare(careVo);
    }

    /**
     * 更改用户头像
     * @param userInfo
     * @return
     */
    public boolean updateUserInfoByUserIdToUrl(UserInfo userInfo) {
        return personalMapper.updateUserInfoByUserIdToUrl(userInfo) > 0;
    }


}
