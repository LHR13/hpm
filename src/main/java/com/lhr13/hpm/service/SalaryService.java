package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Salary;
import com.lhr13.hpm.dao.SalaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryDAO salaryDAO;

    public List<Salary> findAll() {
        List<Salary> salaries = salaryDAO.findAll();
        salaries.removeIf(salary -> salary.getPerson().getInfoState() == 0);
        return salaries;
    }

    public List<Salary> findByName(String name) {
        return salaryDAO.findByPerson_Name(name);
    }
}
