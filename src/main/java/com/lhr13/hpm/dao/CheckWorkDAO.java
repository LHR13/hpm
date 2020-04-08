package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.CheckWork;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckWorkDAO extends JpaRepository<CheckWork, Long> {

    @EntityGraph(value = "checkworkList", type = EntityGraph.EntityGraphType.FETCH)
    List<CheckWork> findAll();

    @EntityGraph(value = "checkworkList", type = EntityGraph.EntityGraphType.FETCH)
    List<CheckWork> findByPerson_Name(String name);
}
