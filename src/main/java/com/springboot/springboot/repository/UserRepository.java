package com.springboot.springboot.repository;

import java.util.List;

import com.springboot.springboot.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    public List<UserModel> findByNameIgnoreCase(String name);
    
}