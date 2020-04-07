package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.Salary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDAO extends JpaRepository<Salary, Long> {
    List<Salary> findAll();

}
