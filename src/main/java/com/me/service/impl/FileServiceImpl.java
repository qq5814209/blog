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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Autowired
    FileMapper fileMapper;


    @Override
    public Object fileUpLoad(Files file, MultipartFile dropzFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 获取上传的原始文件名
        String fileName = dropzFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("/file");
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File destFile = new File(filePath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        // 重新设置文件名为 UUID，以确保唯一
        destFile = new File(filePath, UUID.randomUUID() + fileSuffix);
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // 写入文件
            dropzFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回 JSON 数据，这里只带入了文件名
        result.put("fileName", destFile.getName());
        System.out.println(destFile.getName());

        file.setFile_name(destFile.getName());
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
        file.setUser_id(userInfo.getUser_id());
        return fileMapper.fileUpLoad(file);
    }



    @Override
    public Object fileDown(Files file2, HttpServletRequest request) {
        if (selectCbiIs(file2)){
            fileMapper.fileDown(file2);
            //创建文件
            File fileDown = new File(request.getSession().getServletContext().getRealPath("/"+file2.getFile_name()));
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
}
