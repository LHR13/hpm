package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.PhotoPath;
import com.lhr13.hpm.dao.PhotoPathDAO;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private PhotoPathDAO photoPathDAO;

    public String fileUpload(String fileName, MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String newFileName = UUID.randomUUID().toString() + fileName;
        String path = "/" ;
        System.out.println(path);
        File dest = new File(path + newFileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);//保存文件
            PhotoPath save =new PhotoPath();
            save.setPpath(path + newFileName);
            photoPathDAO.save(save);
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
