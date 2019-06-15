package com.me.mapper;

import com.me.dto.IsDownDto;
import com.me.pojo.Files;

import java.util.List;

public interface FileMapper {
    /*文件上传*/
    public int fileUpLoad(Files file);

    /*文件下载*/
    public int fileDown(IsDownDto isDownDto);

    /*查询是否能下载*/
    public IsDownDto selectCbiIs(String file_id);

    /*获取文件列表*/
    public List<Files> getFiles(Files file);


    /*文件下载添加c币*/
    public int fileDownAdd(IsDownDto isDownDto);

}
