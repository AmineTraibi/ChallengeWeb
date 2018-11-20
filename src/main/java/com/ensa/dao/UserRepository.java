package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entities.*;
public interface UserRepository extends JpaRepository<User,String>{

}
