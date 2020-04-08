package com.lhr13.hpm;

import com.lhr13.hpm.service.MailService;
import com.lhr13.hpm.service.SalaryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HpmApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(HpmApplication.class, args);
//    }
public static void main(String[] args) throws Exception {
    MailService service = new MailService();
    service.sendSimpleMail("1309184697@qq.com", "1309184697@qq.com", "LHR13", "fsd", "fsdf");
}


}
