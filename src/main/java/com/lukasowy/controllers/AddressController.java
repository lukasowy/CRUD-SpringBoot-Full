package com.lukasowy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/edit/{id}")
	public String editAddress(@PathVariable Long id, Model model) {
		model.addAttribute("addressForm", addressService.findOne(id));
		model.addAttribute("roles", userService.userList());
		return "address/form";
	}

	@GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteUser(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addUaddAddressser(@RequestBody Address address) {
		return addressService.addAddress(address);
	}

	@GetMapping("/list/{id}")
	public Address findOne(@PathVariable Long id) {
		return addressService.findOne(id);
	}

	@GetMapping("/list")
	public String addressList(Model model) {
		model.addAttribute("addresses", addressService.addressList());
		return "/address/list";
	}
}
