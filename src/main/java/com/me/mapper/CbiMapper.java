package com.me.mapper;

import com.me.pojo.Cbi;
import com.me.pojo.Vip;

import java.util.List;

public interface CbiMapper {
    public List<Cbi> getCbi(Cbi cbi);

    public Cbi getCbiById(String Cbi_id);
}
