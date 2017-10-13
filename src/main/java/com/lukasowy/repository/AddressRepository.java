package com.lukasowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasowy.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
