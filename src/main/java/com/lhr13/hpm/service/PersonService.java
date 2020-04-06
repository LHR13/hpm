package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.Person;
import com.lhr13.hpm.POJO.Salary;
import com.lhr13.hpm.dao.PersonDAO;
import com.lhr13.hpm.dao.SalaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    SalaryDAO salaryDAO;

    public Boolean add(Person person) {
        Person save = personDAO.save(person);
        if (save != null) {
            return true;
        }else {
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

}
