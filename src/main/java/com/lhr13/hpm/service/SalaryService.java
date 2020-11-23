package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.CheckWork;
import com.lhr13.hpm.POJO.Salary;
import com.lhr13.hpm.dao.SalaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Iterator;
import java.util.List;

@CrossOrigin
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

    public String update(Salary salary) {
        Salary satemp = salaryDAO.findById(salary.getId()).orElse(null);
        if (satemp != null) {
            salary.setPerson(satemp.getPerson());
            satemp = salary;
            salaryDAO.save(satemp);
            return "success";
        }else {
            return "error";
        }
    }
}
