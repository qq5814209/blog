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
     * @param
     * @return
     */
    @RequestMapping(value ="fileUpLoad",method = RequestMethod.POST)
    public Object fileUpLoad(MultipartFile file,
                             @RequestParam("file_cbi")String file_cbi,
                             @RequestParam("file_name")String file_name,
                             @RequestParam("file_intro")String file_intro,
                             HttpServletRequest request){

        Files files = new Files();
        files.setFile_cbi(Integer.parseInt(file_cbi));
        files.setFile_intro(file_intro);
        files.setFile_name(file_name);
        fileService.fileUpLoad(files,file,request);
        return "index";
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


    @ResponseBody
    @RequestMapping(value ="getFiles",method = RequestMethod.POST)
    public Object getFiles(@RequestBody(required = false) Files file) {
        return fileService.getFiles(file);
    }


}
