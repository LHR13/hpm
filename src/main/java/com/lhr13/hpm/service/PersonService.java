package com.lhr13.hpm.service;

import com.lhr13.hpm.bean.Person;
import com.lhr13.hpm.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public Boolean add(Person person) {
        Person save = personDAO.save(person);
        if (save != null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean deleteById(Integer id) {
        Person person = personDAO.findById(id).orElse(null);
        if (person != null) {
            person.setInfoState(0);
            personDAO.save(person);
            return true;
        }else {
            return false;
        }
    }

    public Boolean updById(Person person) {
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

    public Person findById(Integer id) {
            return personDAO.findById(id).orElse(null);

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

    public List<Person> findByName(String name) {
        return personDAO.findByName(name);
    }

    public List<Person> findByDel(String dep) {
        return personDAO.findByDep(dep);
    }
}
