package com.me.service;

import com.me.dto.ShowDto;
import com.me.vo.ShowVo;

import java.util.List;

public interface InquireService {
    public List<ShowDto> getBlogsByTypeName(ShowVo showVo);

    public boolean addPersonalCategory(ShowVo showVo);
    public List<ShowDto> AllPersonalCategory(ShowVo showVo);
}
