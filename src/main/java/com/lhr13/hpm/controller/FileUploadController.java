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
import java.util.Date;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/upload")
    public String upload() {
        return "upload.html";
    }

    @ResponseBody
    @PostMapping("/upload")
    public void fileUpload(@RequestParam("username") String username, @RequestParam("file") MultipartFile file, HttpServletRequest req){
        String filename = file.getOriginalFilename();
        fileUploadService.fileUpload(username, filename, file, req);
    }
}
