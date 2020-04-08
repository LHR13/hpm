package com.lhr13.hpm.controller;


import com.lhr13.hpm.POJO.CheckWork;
import com.lhr13.hpm.service.CheckWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/checkwork")
public class CheckWorkController {

    @Autowired
    CheckWorkService checkWorkService;

    @GetMapping("/findAll")
    public List<CheckWork> findAll() {
        List<CheckWork> checkWorks = checkWorkService.findAll();
        return checkWorks;
    }

    @GetMapping("/findByName")
    public List<CheckWork> findByName(String name) {
        List<CheckWork> checkWorks = checkWorkService.findByName(name);
        return checkWorks;
    }
}
