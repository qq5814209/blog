package com.me.vo;


import com.me.pojo.Favorites;

import java.util.List;

/**
 * 用于展示 collect_center.html 页面
 */
public class FavoritesVo {
//    收藏夹基础信息
    private Favorites favorites;
//    收藏夹中有几条内容
    private int contents;
//    收藏夹中有多少关注
    private int attentions = 0;
//    收藏时的信息
    private List<CollectVo> collectVoList;

    public Favorites getFavorites() {
        return favorites;
    }

    public void setFavorites(Favorites favorites) {
        this.favorites = favorites;
    }

    public int getContents() {
        return contents;
    }

    public void setContents(int contents) {
        this.contents = contents;
    }

    public int getAttentions() {
        return attentions;
    }

    public void setAttentions(int attentions) {
        this.attentions = attentions;
    }

    public List<CollectVo> getCollectVoList() {
        return collectVoList;
    }

    public void setCollectVoList(List<CollectVo> collectVoList) {
        this.collectVoList = collectVoList;
    }

    @Override
    public String toString() {
        return "FavoritesVo{" +
                "favorites=" + favorites +
                ", contents=" + contents +
                ", attentions=" + attentions +
                ", collectVoList=" + collectVoList +
                '}';
    }
}
