package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDAO extends JpaRepository<Salary, Long> {
}
