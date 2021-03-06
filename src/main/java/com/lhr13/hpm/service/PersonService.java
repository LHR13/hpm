package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.CheckWork;
import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.POJO.Salary;
import com.lhr13.hpm.dao.CheckWorkDAO;
import com.lhr13.hpm.dao.PersonDAO;
import com.lhr13.hpm.dao.SalaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private SalaryDAO salaryDAO;
    @Autowired
    private CheckWorkDAO checkWorkDAO;

    public Boolean add(Person person) {
        try {
            Salary salary = new Salary();
            CheckWork checkWork = new CheckWork();
            person.setSalary(salary);
            person.setCheckwork(checkWork);
            person.setInfoState(1);
            salary.setPerson(person);
            checkWork.setPerson(person);
            personDAO.save(person);
            salaryDAO.save(salary);
            checkWorkDAO.save(checkWork);
            return true;
        }catch (Exception e) {
            return false;
        }

    }

    public Boolean delete(Person person) {
        Person person1 = personDAO.findById(person.getId()).orElse(null);
        try {
            person1.setInfoState(0);
            personDAO.save(person1);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean update(Person person) {
        Person person1 = personDAO.findById(person.getId()).orElse(null);
        if (person1 != null) {
            person.setInfoState(1);
            person1 = person;
            personDAO.save(person1);
            return true;
        }else {
            return false;
        }
    }

    public List<Person> findByDel(String dep) {
        return personDAO.findByDep(dep);
    }

    public List<Person> findByName(String name) {
        return personDAO.findByName(name);

    }

    public List<Person> findAll() {
        List<Person> people = personDAO.findAll();
        Iterator<Person> ps = people.iterator();
        while (ps.hasNext()) {
            Person person1 = ps.next();
            if (person1.getInfoState() == 0) {
                ps.remove();
            }
        }
        return people;
    }

    public Optional<Person> findById(Long id) {
        return personDAO.findById(id);
    }
}
