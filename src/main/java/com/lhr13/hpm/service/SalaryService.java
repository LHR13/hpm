package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.dao.PersonDAO;
import com.lhr13.hpm.dao.SalaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private SalaryDAO salaryDAO;

//    public List<Person> findAll() {
//
//    }


}
