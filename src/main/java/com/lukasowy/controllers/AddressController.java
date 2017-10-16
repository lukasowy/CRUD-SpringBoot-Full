package com.lukasowy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lukasowy.models.Address;
import com.lukasowy.services.AddressService;

@Controller
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

	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String addressList(Model model) {
		model.addAttribute("addresses", addressService.addressList());
		return "/address/list";
	}
}
