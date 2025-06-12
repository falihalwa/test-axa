package com.testAxa.testAxa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testAxa.testAxa.model.entity.User;

@Repository
public interface UserReposistory extends JpaRepository<User,Long>{
    
}
