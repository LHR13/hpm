package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    @EntityGraph(value = "personList", type = EntityGraph.EntityGraphType.FETCH)
    List<Person> findByName(String name);

    @EntityGraph(value = "personList", type = EntityGraph.EntityGraphType.FETCH)
    @Query(value = "SELECT * FROM person WHERE Dep = ?1", nativeQuery = true)
    List<Person> findByDep(String dep);

//    @Query(value = "SELECT salary_id FROM person WHERE name = ?1", nativeQuery = true)
//    Long findSalaryByPersonName(String name);

    @EntityGraph(value = "personList", type = EntityGraph.EntityGraphType.FETCH)
    List<Person> findAll();


}
