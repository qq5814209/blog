package com.me.service;

import com.me.pojo.Files;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface FileService {


    public Object fileDown(String file_id, HttpServletRequest request, HttpServletResponse resp);

    public Object fileUpLoad(Files file, MultipartFile dropzFile, HttpServletRequest request);


    public List<Files> getFiles(Files file);

    Object getFilesById(HttpSession session);

}
