package com.lukasowy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukasowy.models.Address;
import com.lukasowy.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	private AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}

	@RequestMapping("/add")
	public Address addUaddAddressser(@RequestBody Address address) {
		return addressService.addAddress(address);
	}

	@RequestMapping("/list/{id}")
	public Address findOne(@PathVariable Long id) {
		return addressService.findOne(id);
	}

	@RequestMapping("/list")
	public List<Address> addressList() {
		return addressService.addressList();
	}
}
