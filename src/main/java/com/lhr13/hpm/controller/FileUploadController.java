package com.lhr13.hpm.controller;

import com.lhr13.hpm.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public void upload(MultipartFile uploadFile, HttpServletRequest request) {
        fileUploadService.upload(uploadFile, request);
    }

    @PostMapping("/uploads")
    public void upload(MultipartFile[] uploadFiles, HttpServletRequest request) {
        fileUploadService.upload(uploadFiles, request);
    }
}
