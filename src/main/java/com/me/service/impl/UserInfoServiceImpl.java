package com.me.service.impl;

import com.me.mapper.UserInfoMapper;
import com.me.pojo.Favorites;
import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.vo.FavoritesVo;
import com.me.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询用户信息、修改用户信息用
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */
    public UserInfo login(String user, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_name(user);
        userInfo.setPassword(password);
        return userInfoMapper.login(userInfo);
    }

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    public UserInfoVo selectUserInfo(int userId) {

        UserInfo userInfo = userInfoMapper.selectUserInfo(userId);
        int fans = userInfoMapper.selectCareByFans(userId);
        int attentions = userInfoMapper.selectCareByAttentions(userId);

        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserInfo(userInfo);
        userInfoVo.setFans(fans);
        userInfoVo.setAttentions(attentions);

        return userInfoVo;
    }

    /**
     * 根据用户id查询该用户的收藏夹信息
     * @param userId
     * @return
     */
    public List<FavoritesVo> selectFavoritesByUserId(int userId) {
        List<Favorites> favoritesList = userInfoMapper.selectFavoritesByUserId(userId);
        List<FavoritesVo> favoritesVoList = new ArrayList<FavoritesVo>();

        for (Favorites favorites : favoritesList) {
            FavoritesVo favoritesVo = new FavoritesVo();
            int favorites_id = favorites.getFavorites_id();
            int contents = userInfoMapper.selectFavoritesCollectByFavoritesId(favorites_id);
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

        return userInfoMapper.selectFavoritesByFavoritesId(favorites_id);
    }
}
