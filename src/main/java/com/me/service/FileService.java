package com.me.service;

import com.me.pojo.Files;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {


    public Object fileDown(Files file,HttpServletRequest request);

    public Object fileUpLoad(Files file, MultipartFile dropzFile, HttpServletRequest request);

    /*查询是否能下载*/
    public boolean selectCbiIs(Files file);

}
