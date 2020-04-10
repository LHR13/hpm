package com.lhr13.hpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail (String from, String to,
                                String subject, String content) throws Exception{
        SimpleMailMessage simpleMailMessage1 = new SimpleMailMessage();
        simpleMailMessage1.setFrom(from);
        simpleMailMessage1.setTo(to);
        simpleMailMessage1.setSubject(subject);
        simpleMailMessage1.setText(content);
        System.out.println(simpleMailMessage1.toString());
        javaMailSender.send(simpleMailMessage1);
    }

    public void sendSimpleMail (String from, String to, String cc,
                               String subject, String content) throws Exception{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setCc(cc);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        System.out.println(simpleMailMessage.toString());
        javaMailSender.send(simpleMailMessage);
    }
}
