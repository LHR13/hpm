package com.lhr13.hpm.controller;

import com.lhr13.hpm.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/simplemsg")
    public String sendSimpleMail(String from, String to, String cc,
                               String subject, String content) {
        try {
            if (cc != null) {
                mailService.sendSimpleMail(from, to, cc, subject, content);
            }else {
                mailService.sendSimpleMail(from, to, subject, content);
            }
        } catch (Exception e) {
            System.out.println("邮件发送失败 " + e.getMessage());;
            return "邮件发送失败 " + e.getMessage();
        }
        return "邮件发送成功";
    }
}
