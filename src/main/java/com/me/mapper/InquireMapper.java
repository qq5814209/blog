package com.me.mapper;

import com.me.dto.ShowDto;
import com.me.vo.ShowVo;

import java.util.List;

public interface InquireMapper {
    public List<ShowDto> getBlogsByTypeName(ShowVo showVo);
    public int addPersonalCategory(ShowVo showVo);
    public List<ShowDto> AllPersonalCategory(ShowVo showVo);
}
