package com.learn.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springsecurity.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
}
