package com.first.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}