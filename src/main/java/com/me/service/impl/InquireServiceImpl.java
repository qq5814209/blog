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


    public List<ShowDto> getBlogsByTypeName(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.getBlogsByTypeName(showVo);
        for(ShowDto showDto : showDtos){
            String str = showDto.getBlog_content().substring(0,5);
            System.out.println(showDto);
            showDto.setBlog_content(str);
        }
        return showDtos;
    }

    @Transactional
    public boolean addPersonalCategory(ShowVo showVo) {
        System.out.println("1232312+");
        int count = inquireMapper.addPersonalCategory(showVo);
        System.out.println("count++++++++++"+count);
        if(count>0) {
            return true;
        }else{
            return false;
        }

    }

    public List<ShowDto> allPersonalCategory(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.allPersonalCategory(showVo);
        return showDtos;
    }

    @Transactional
    public boolean deletePersonalCategory(ShowVo showvo) {
        int count = inquireMapper.deletePersonalCategory(showvo);
        if(count>0) {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updatePersonalCategory(ShowVo showvo) {
        int count = inquireMapper.updatePersonalCategory(showvo);

        if(count>0) {
            return true;
        }
        return false;
    }


    public List<ShowDto> searchBlogs(ShowVo showvo) {
        showvo.setBlog_content("%"+showvo.getType_name()+"%");
        showvo.setBlog_title("%"+showvo.getType_name()+"%");
        List<ShowDto> showDtos = inquireMapper.searchBlogs(showvo);
        for(ShowDto showDto : showDtos){
            String str = showDto.getBlog_content().substring(0,5);
            showDto.setBlog_content(str);
        }
        return showDtos;
    }

    @Transactional
    public boolean deleteBlogbyBlog_id(ShowVo showVo) {
        int count = inquireMapper.deleteBlogbyBlog_id(showVo);
        if(count>0) {
            return true;
        }
        return false;
    }


    public List<ShowDto> getBlogsByUserId(ShowVo showVo) {
        List<ShowDto> showDtos = inquireMapper.getBlogsByUserId(showVo);
        return showDtos;
    }

}
