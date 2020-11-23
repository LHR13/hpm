package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.User;
import com.lhr13.hpm.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class LoginService {


    @Autowired
    private UserDAO userDAO;

    public String login(String username, String password) {
        List<User> users = userDAO.findByUsername(username);
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                return "success";
            }
        }
        return "error";
    }

}
