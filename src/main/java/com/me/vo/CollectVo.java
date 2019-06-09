package com.me.vo;

import com.me.pojo.BlogInfo;
import com.me.pojo.Collect;

/**
 * 用于展示 collect_center.html 页面
 */
public class CollectVo {
    private BlogInfo blogInfo;
    private Collect collect;

    public BlogInfo getBlogInfo() {
        return blogInfo;
    }

    public void setBlogInfo(BlogInfo blogInfo) {
        this.blogInfo = blogInfo;
    }

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }

    @Override
    public String toString() {
        return "CollectVo{" +
                "blogInfo=" + blogInfo +
                ", collect=" + collect +
                '}';
    }
}
