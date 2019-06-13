package com.me.controller;


import com.me.pojo.Files;
import com.me.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;



@Controller
public class FileController {

    @Autowired
    FileService fileService;


    /**
     * 文件上传
     * @param dropzFile
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="fileUpLoad",method = RequestMethod.POST)
    public Object fileUpLoad(@RequestBody Files file, MultipartFile dropzFile, HttpServletRequest request) {
        return fileService.fileUpLoad(file,dropzFile,request);
    }


    /**
     * 文件下载
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="fileDown",method = RequestMethod.POST)
    public Object fileDown(@RequestBody Files file,  HttpServletRequest request) {
        return fileService.fileDown(file,request);
    }


}
