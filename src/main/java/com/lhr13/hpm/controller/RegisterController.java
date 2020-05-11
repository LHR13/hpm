package com.lhr13.hpm.controller;

import com.lhr13.hpm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String reg2html() {
        return "register.html";
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        return registerService.register(username, password);
    }
}
