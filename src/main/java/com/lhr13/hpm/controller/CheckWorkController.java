package com.lhr13.hpm.controller;


import com.lhr13.hpm.POJO.CheckWork;
import com.lhr13.hpm.service.CheckWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")
    public String update(@RequestBody CheckWork checkWork) {
        return checkWorkService.update(checkWork);
    }


}
