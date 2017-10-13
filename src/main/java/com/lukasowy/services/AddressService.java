package com.lukasowy.services;

import java.util.List;

import com.lukasowy.models.Address;

public interface AddressService {
	List<Address> addressList();

	Address findOne(Long id);

	Address addAddress(Address address);

	String deleteAddress(Long id);
}
