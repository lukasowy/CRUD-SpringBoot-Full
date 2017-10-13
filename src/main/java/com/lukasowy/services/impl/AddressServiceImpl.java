package com.lukasowy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukasowy.models.Address;
import com.lukasowy.repository.AddressRepository;
import com.lukasowy.repository.UserRepository;
import com.lukasowy.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private UserRepository userRepository;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public Address addAddress(Address address) {
		address.setUser(userRepository.findOne(address.getUserId()));
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.delete(id);
		return "{'message': Address deleted}";
	}

}
