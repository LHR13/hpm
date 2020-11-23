package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.User;
import com.lhr13.hpm.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Service
public class RegisterService {
    @Autowired
    private UserDAO userDAO;

    public String register(String username, String password) {
        if (userDAO.existsByUsername(username)) {
            return "用户名已存在";
        }
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDAO.save(user);
            return "注册成功";
        }catch (Exception e) {
            e.printStackTrace();
            return "注册失败";
        }
    }
}
