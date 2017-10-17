package com.lukasowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasowy.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
