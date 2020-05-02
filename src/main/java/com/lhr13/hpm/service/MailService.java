package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PersonDAO personDAO;

    public void sendSimpleMail (Person person) throws Exception{
        SimpleMailMessage simpleMailMessage1 = new SimpleMailMessage();
        simpleMailMessage1.setFrom("1309184697@qq.com");
        simpleMailMessage1.setTo(person.getMail());
        simpleMailMessage1.setSubject("薪资一览");
        simpleMailMessage1.setText("尊敬的" + person.getName() + "：" + "\n" +
                "您本月的薪资为：" + "\n" +
                "基本工资：" + person.getSalary().getBwage() + "\n" +
                "绩效工资：" + person.getSalary().getMwage() + "\n" +
                "奖金：" + person.getSalary().getReward() + "\n" +
                "补贴：" + person.getSalary().getSubsidy() + "\n" +
                "社保扣款：" + person.getSalary().getSodeductions() + "\n" +
                "个人所得税：" + person.getSalary().getIncometax() + "\n" +
                "罚款：" + person.getSalary().getFine() + "\n" +
                "实际所得：" + (person.getSalary().getBwage() +
                                person.getSalary().getMwage() +
                                person.getSalary().getReward() +
                                person.getSalary().getSubsidy() -
                                person.getSalary().getSodeductions() -
                                person.getSalary().getIncometax() -
                                person.getSalary().getFine())
                );
        System.out.println(person.getSalary().getFine());
        javaMailSender.send(simpleMailMessage1);
    }
}
