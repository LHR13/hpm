package com.lhr13.hpm.dao;

import com.lhr13.hpm.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    List<User> findByUsername(String name);
    List<User> findAll();
}
