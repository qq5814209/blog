package com.me.mapper;

import com.me.pojo.Cbi;
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
}
