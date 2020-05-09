package com.lhr13.hpm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadService {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");
    List<String> filesPath = new ArrayList<>();

    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        String realPath =
                request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = simpleDateFormat.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();  //得到上传的文件名
        String newName = UUID.randomUUID().toString() +
                oldName.substring(oldName.lastIndexOf("."));
        try {
            uploadFile.transferTo(new File(folder, newName));   //springMVC封装的方法，用于将上传的文件保存在服务器上
            String filePath = request.getScheme() + "://" + request.getServerName() +
                    ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            return "上传成功";    //getScheme()：request.getScheme() 返回当前链接使用的协议
            //比如，一般应用返回http;SSL返回https;
            //getServerPort()：getServerPort获取的是URL请求的端口
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    public String upload(MultipartFile[] uploadFiles, HttpServletRequest request) {
        String realPath =
                request.getSession().getServletContext().getRealPath("/uploadFiles/");
        String format = simpleDateFormat.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        for (MultipartFile uploadFile : uploadFiles)
        {
            String oldName = uploadFile.getOriginalFilename();  //得到上传的文件名
            String newName = UUID.randomUUID().toString() +
                    oldName.substring(oldName.lastIndexOf("."));
            try {
                uploadFile.transferTo(new File(folder, newName));   //springMVC封装的方法，用于将上传的文件保存在服务器上
                String filePath = request.getScheme() + "://" + request.getServerName() +
                        ":" + request.getServerPort() + "/uploadFiles/" + format + newName;
                filesPath.add(filePath);    //getScheme()：request.getScheme() 返回当前链接使用的协议
                //比如，一般应用返回http;SSL返回https;
                //getServerPort()：getServerPort获取的是URL请求的端口
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传成功";
    }
}
