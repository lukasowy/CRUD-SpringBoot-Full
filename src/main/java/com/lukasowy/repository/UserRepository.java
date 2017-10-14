package com.lukasowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasowy.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
