package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    @Query(value = "SELECT * FROM personfortest WHERE Dep = ?1", nativeQuery = true)
    List<Person> findByDep(String dep);
}
