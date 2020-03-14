package com.lhr13.hpm.dao;

import com.lhr13.hpm.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);
}
