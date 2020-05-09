package com.lhr13.hpm.controller;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public String add(@RequestBody Person person) {
        if (personService.add(person)) {
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @CrossOrigin
    @GetMapping("/delete")
    public String delByName(@RequestBody Person person) {
        if (personService.delete(person)) {
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @CrossOrigin
    @PostMapping("/update")
    public String upById(@RequestBody Person person) {
        if (personService.update(person)) {
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findAll")
    public List<Person> findAll() {
        List<Person> people = personService.findAll();
        return people;
    }


    @CrossOrigin
    @GetMapping("/findByDep")
    public List<Person> findByDel(String dep) {
        return personService.findByDel(dep);
    }

    @CrossOrigin
    @GetMapping("/findByName")
    public List<Person> findByName(String name) {
        return personService.findByName(name);
    }
}

