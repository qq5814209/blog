package com.me.mapper;

import com.me.dto.IsDownDto;
import com.me.dto.UserCbiDto;
import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.UserInfo;
import com.me.pojo.Vip;

import java.util.List;

public interface CbiMapper {
    /**
     * 获取C币套餐
     * @param cbi
     * @return
     */
    public List<Cbi> getCbi(Cbi cbi);


    /**
     * 获取指定的套餐
     * @param Cbi_id
     * @return
     */
    public Cbi getCbiById(String Cbi_id);

    /**
     * 购买C币后给用户添加C币数
     */
    public void addUserCbi(UserCbiDto userCbiDto);

    public UserInfo getUserCbi(UserInfo userInfo);

    /**
     * 获取用户C币消费记录
     * @param userInfo
     * @return
     */
    public List<IsDownDto> getCbiXiao(UserInfo userInfo);
}
