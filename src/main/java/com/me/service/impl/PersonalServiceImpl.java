package com.me.service.impl;

import com.me.dto.SumDto;
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
    public UserInfoDto selectUserInfoAndAttentionsAndFans(int userId) {

        return personalMapper.selectUserInfoAndAttentionsAndFans(userId);
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
        //查询该用户已经关注了哪些人
        List<UserInfo> userInfos = personalMapper.selectCareByUserId(user_id);
        List<String> uf_ids = new ArrayList<String>();
        for (UserInfo userInfo : userInfos) {
            uf_ids.add(String.valueOf(userInfo.getUser_id()));
            System.out.println(userInfo);
        }
        //判断是否有新增关注的人和已经关注的人是否有重复的，重复就不再执行添加操作
        if(!uf_ids.contains(uf_id) || uf_ids.isEmpty()){
            CareVo careVo = new CareVo();
            careVo.setUt_id(user_id);
            careVo.setUf_id(Integer.parseInt(uf_id));
            personalMapper.myCare(careVo);
        }
    }

    /**
     * 更改用户头像
     * @param userInfo
     * @return
     */
    public boolean updateUserInfoByUserIdToUrl(UserInfo userInfo) {
        return personalMapper.updateUserInfoByUserIdToUrl(userInfo) > 0;
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    public boolean updateUserInfo(UserInfo userInfo) {

        return personalMapper.updateUserInfo(userInfo) > 0;
    }

    /**
     * 添加收藏夹
     * @param favorites
     * @return
     */
    public String insertFavorites(Favorites favorites) {
        if (!favorites.getFavorites_title().equals("") && favorites != null){
            int i = personalMapper.insertFavorites(favorites);
            return String.valueOf(i > 0);
        }
        return "请输入收藏夹的名字";
    }

    /**
     * 通过收藏夹id查询收藏夹信息
     * @param favoritesId
     * @return
     */
    public Favorites selectFavoritesId(int favoritesId) {
        return personalMapper.selectFavoritesId(favoritesId);
    }

    /**
     * 修改收藏夹信息
     * @param favorites
     * @return
     */
    public String updateFavorites(Favorites favorites) {
        if (!favorites.getFavorites_title().equals("") && favorites.getFavorites_title() != null){

            return String.valueOf(personalMapper.updateFavorites(favorites) > 0);
        }
        return "请输入收藏夹标题";
    }

    /**
     * 删除收藏夹
     * @param favoritesId
     * @return
     */
    public boolean deleteFavorites(int favoritesId) {
        return personalMapper.deleteFavorites(favoritesId)>0;
    }


    /**
     * 根据用户id统计各种信息总数量
     * @param user_id
     * @return
     */
    @Override
    public SumDto selectCount(int user_id) {
        return personalMapper.selectCount(user_id);
    }
}
