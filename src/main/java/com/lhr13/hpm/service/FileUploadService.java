package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.POJO.PhotoPath;
import com.lhr13.hpm.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Service
public class FileUploadService {
    @Autowired
    private PersonDAO personDAO;

    public String fileUpload(String id, String fileName, MultipartFile file, HttpServletRequest req){
        if(file.isEmpty()){
            return "false";
        }
        String newFileName = UUID.randomUUID().toString() + fileName;
        String path = "/" ;
        File dest = new File(path + newFileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);//保存文件
            PhotoPath save =new PhotoPath();
            save.setPpath(path + newFileName);
            Person person = personDAO.findById(Long.valueOf(id)).get();
            System.out.println(person.getName());
            String netPath = req.getScheme() + "://" + req.getServerName() + ":"
                    + req.getServerPort() + "/photo" + path + newFileName;
            person.setPhotoURL(netPath);
            personDAO.save(person);
            return netPath;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "上传失败";
        }
    }
}