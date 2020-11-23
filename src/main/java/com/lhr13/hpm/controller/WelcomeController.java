package com.lhr13.hpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String hello() {
        //默认是返到templates下的login.html
        return "welcome.html";
    }
}
