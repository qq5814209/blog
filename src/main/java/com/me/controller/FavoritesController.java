package com.me.controller;

import com.me.pojo.BlogInfo;
import com.me.pojo.Favorites;
import com.me.service.FavoritesService;
import com.me.vo.FavoritesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 查询收藏夹信息、收藏用controller
 */
@Controller
public class FavoritesController {


    @Autowired
    FavoritesService favoritesService;

    /**
     * 根据用户 id 查询用户收藏夹信息，用户展示 collect_center.html 页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByUserId", method = RequestMethod.POST)
    public Object selectFavoritesByUserId() {
//        因不知 id 是 session 中取，还是直接传 int id ，故先写死
        int userId = 1;

        return favoritesService.selectFavoritesByUserId(userId);
    }

    /**
     * 根据收藏夹id查询收藏夹中内容
     * @param favorites_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByFavoritesId", method = RequestMethod.POST)
    public Object selectFavoritesByFavoritesId(@RequestParam int favorites_id) {

        List<FavoritesVo> favoritesVoList = favoritesService.selectFavoritesByFavoritesId(favorites_id);
        return favoritesVoList;
    }
}
