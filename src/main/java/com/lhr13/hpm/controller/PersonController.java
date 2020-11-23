package com.lhr13.hpm.controller;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public String add(@RequestBody Person person) {
        if (personService.add(person)) {
            return "success";
        }else {
            return "error";
        }
    }

    @CrossOrigin
    @GetMapping("/delete")
    public String delByName(@RequestBody Person person) {
        if (personService.delete(person)) {
            return "success";
        }else {
            return "error";
        }
    }

    @CrossOrigin
    @PostMapping("/update")
    public String upById(@RequestBody Person person) {
        if (personService.update(person)) {
            return "success";
        }else {
            return "error";
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

    @GetMapping("/findByid")
    public Optional<Person> findByid(Long id) {
        return personService.findById(id);
    }


}

