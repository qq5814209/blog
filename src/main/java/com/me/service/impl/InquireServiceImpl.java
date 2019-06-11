package com.me.service.impl;

import com.me.dto.ShowDto;
import com.me.mapper.InquireMapper;
import com.me.service.InquireService;
import com.me.vo.ShowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InquireServiceImpl implements InquireService{

    @Autowired
    InquireMapper inquireMapper;

    //根据blog类别名查询blog
    public List<ShowDto> getBlogsByTypeName(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.getBlogsByTypeName(showVo);
        return showDtos;
    }

    @Transactional
    public boolean addPersonalCategory(ShowVo showVo) {
        int count = inquireMapper.addPersonalCategory(showVo);
        if(count>0) {
            return true;
        }
        return false;
    }

    public List<ShowDto> AllPersonalCategory(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.AllPersonalCategory(showVo);
        return showDtos;
    }


}
