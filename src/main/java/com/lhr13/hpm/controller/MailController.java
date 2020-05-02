package com.lhr13.hpm.controller;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/simplemsg")
    public String sendSimpleMail(@RequestBody Person person) {
        try {
            mailService.sendSimpleMail(person);
        } catch (Exception e) {
            System.out.println("邮件发送失败 " + e.getMessage());;
            return "邮件发送失败 " + e.getMessage();
        }
        return "邮件发送成功";

    }
}
