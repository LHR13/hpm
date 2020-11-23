package com.lhr13.hpm.controller;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/simplemsg")
    public @ResponseBody String sendSimpleMail(@RequestParam("id") String id) {
        try {
            mailService.sendSimpleMail(id);
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());;
            return "error " + e.getMessage();
        }
        return "success";

    }
}
