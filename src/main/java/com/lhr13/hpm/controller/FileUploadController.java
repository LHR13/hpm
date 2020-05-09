package com.lhr13.hpm.controller;

import com.lhr13.hpm.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/upload")
    public String upfile(){
        return "loadfile.html";
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("filename") MultipartFile uploadFile) {
        fileUploadService.upload(uploadFile);
    }

    @PostMapping("/uploads")
    public void upload(MultipartFile[] uploadFiles, HttpServletRequest request) {
        fileUploadService.upload(uploadFiles, request);
    }
}
