package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.POJO.Salary;
import com.lhr13.hpm.dao.PersonDAO;
import com.lhr13.hpm.dao.SalaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryDAO salaryDAO;

    public List<Salary> findAll() {
        List<Salary> salaries = salaryDAO.findAll();
        Iterator<Salary> sy = salaries.iterator();
        while (sy.hasNext()) {
            Salary salary = sy.next();
            if (salary.getPerson().getInfoState() == 0) {
                sy.remove();
            }
        }
        return salaries;
    }


}