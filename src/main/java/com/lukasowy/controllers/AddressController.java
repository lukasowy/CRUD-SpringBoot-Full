package com.lukasowy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lukasowy.models.Address;
import com.lukasowy.services.AddressService;
import com.lukasowy.services.UserService;

@Controller
@RequestMapping("/address")
public class AddressController {

	private AddressService addressService;
	private UserService userService;

	@Autowired
	public AddressController(AddressService addressService, UserService userService) {
		this.addressService = addressService;
		this.userService = userService;
	}

	@GetMapping("/form")
	public String addressForm(Model model) {
		model.addAttribute("addressForm", new Address());
		model.addAttribute("users", userService.userList());
		return "address/form";
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addUaddAddressser(@ModelAttribute Address address, Model model) {
		model.addAttribute("message",
				addressService.addAddress(address).getUser().getUserName() + " address added successfully");
		return "message";
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
