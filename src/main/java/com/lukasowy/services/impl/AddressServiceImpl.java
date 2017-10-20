package com.lukasowy.services.impl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
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
	public String addAddress(Address address) {
		String message = "";
		JSONObject jsonObject = new JSONObject();
		try {
		if (address.getId() == null) {
			message = " added";
		} else {
			message = " updated";
		}
		address.setUser(userRepository.findOne(address.getUserId()));
			jsonObject.put("message", addressRepository.save(address).getCountry() + message + " successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.delete(id);
		return "Address deleted";
	}

}
