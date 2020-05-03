package com.lhr13.hpm;

import com.lhr13.hpm.service.MailService;
import com.lhr13.hpm.service.SalaryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HpmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpmApplication.class, args);
    }
//    public static void main(String[] args) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println("1" + bCryptPasswordEncoder.encode("111"));
//        System.out.println("2" + bCryptPasswordEncoder.encode("222"));
//    }
}
