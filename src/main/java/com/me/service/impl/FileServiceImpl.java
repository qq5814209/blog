package com.me.service.impl;

import com.me.dto.IsDownDto;
import com.me.mapper.FileMapper;
import com.me.pojo.Files;
import com.me.pojo.UserInfo;
import com.me.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {


    @Autowired
    FileMapper fileMapper;


    @Override
    public Object fileUpLoad(Files file, MultipartFile dropzFile, HttpServletRequest request) {
        if(dropzFile!=null && !dropzFile.isEmpty()){
            String fileName = dropzFile.getOriginalFilename();
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            String filePath = request.getSession().getServletContext().getRealPath("/file");
            File destFile = new File(filePath);
            if (!destFile.exists()) {
                destFile.mkdirs();
            }
            destFile = new File(filePath, file.getFile_name()+fileSuffix);
            if (!destFile.exists()) {
                try {
                    destFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                destFile = new File(filePath, file.getFile_name()+"1"+fileSuffix);
                if (!destFile.exists()){
                    try {
                        destFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                dropzFile.transferTo(destFile);
                file.setFile_name(destFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(destFile.getName());
            //UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
            file.setUser_id(5);
        }
        return fileMapper.fileUpLoad(file);
    }



    @Override
    public Object fileDown(Files file2, HttpServletRequest request) {
        IsDownDto isDownDto = fileMapper.selectCbiIs(file2);
        UserInfo userinfo =(UserInfo) request.getSession().getAttribute("userInfo");
        file2.setUser_id(userinfo.getUser_id());
        System.out.println("传入的："+file2);
        System.out.println("返回的文件："+isDownDto);
        System.out.println("文件所需的c币："+isDownDto.getFile_cbi());
        file2.setFile_cbi(isDownDto.getFile_cbi());
        if (isDownDto.getCbis()>isDownDto.getFile_cbi()){
            //创建文件
            File fileDown = new File(request.getSession().getServletContext().getRealPath("/file/"+isDownDto.getFile_name()));
            byte[] body = null;
            //创建输入流(从硬盘读取数据)
            InputStream is = null;
            try {
                is = new FileInputStream(fileDown);
                //创建字节数组并指定长度
                body = new byte[is.available()];
                //将数据从输入流导到输出流
                is.read(body);
                //创建响应头并设置指定值
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attchement;filename=" + fileDown.getName());
                //设置HTTP响应状态。
                HttpStatus statusCode = HttpStatus.OK;
                //创建响应实体对象
                ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
                fileMapper.fileDown(file2);
                System.out.println(entity);
                return entity;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;

    }



    @Override
    public boolean selectCbiIs(Files file) {
        IsDownDto isDownDto = fileMapper.selectCbiIs(file);
        if (isDownDto.getCbis()>isDownDto.getFile_cbi()){
            return true;
        }
        return false;
    }

    @Override
    public List<Files> getFiles(Files file) {
        return fileMapper.getFiles(file);
    }
}
