package com.lhr13.hpm.controller;

import com.lhr13.hpm.POJO.Salary;
import com.lhr13.hpm.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;



    @GetMapping("/findAll")
    public List<Salary> findAll() {
        List<Salary> salaries = salaryService.findAll();
        return salaries;
    }

    @GetMapping("/findByName")
    public List<Salary> findByName(String name) {
        List<Salary> salaries = salaryService.findByName(name);
        return salaries;
    }
}
