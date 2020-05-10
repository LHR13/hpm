package com.lhr13.hpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class FileUploadController {

    @GetMapping("/upload")
    public String upload() {
        return "upload.html";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        String path = "/" ;
        System.out.println(path);
        File dest = new File(path + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);//保存文件
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }
}
