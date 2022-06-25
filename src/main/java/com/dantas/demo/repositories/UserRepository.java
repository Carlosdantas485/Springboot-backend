package com.dantas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.demo.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
