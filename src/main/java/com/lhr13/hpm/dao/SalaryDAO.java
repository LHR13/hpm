package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.Salary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDAO extends JpaRepository<Salary, Long> {
    @EntityGraph(value = "salaryList", type = EntityGraph.EntityGraphType.FETCH)
    List<Salary> findAll();

    @EntityGraph(value = "salaryList", type = EntityGraph.EntityGraphType.FETCH)
//    @Query(value = "SELECT * FROM salary JOIN person ON person.id = salary.person_id ", nativeQuery = true)
    List<Salary> findByPerson_Name(String name);

}
