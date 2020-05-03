package com.lhr13.hpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String hello() {
        //这边我们,默认是返到templates下的login.html
        return "login_page.html";
    }
}

