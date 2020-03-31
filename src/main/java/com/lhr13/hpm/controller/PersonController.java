package com.lhr13.hpm.controller;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
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

    @GetMapping("/delete")
    public String delById(@RequestBody Person person) {
        if (personService.deleteById(person.getId())) {
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @PostMapping("/update")
    public String upById(@RequestBody Person person) {
        if (personService.updById(person)) {
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        List<Person> people = personService.findAll();
        return people;
    }

    @GetMapping("/findByName")
    public List<Person> findByName(String name) {
        return personService.findByName(name);
    }

    @GetMapping("/findByDep")
    public List<Person> findByDel(String dep) {
        return personService.findByDel(dep);
    }
}

