package com.me.mapper;

import com.me.dto.IsDownDto;
import com.me.pojo.Files;

public interface FileMapper {
    /*文件上传*/
    public int fileUpLoad(Files file);

    /*文件下载*/
    public int fileDown(Files file);

    /*查询是否能下载*/
    public IsDownDto selectCbiIs(Files file);
}
