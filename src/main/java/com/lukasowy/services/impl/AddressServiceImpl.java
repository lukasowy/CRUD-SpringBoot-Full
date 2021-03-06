package com.lukasowy.services.impl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.lukasowy.models.Address;
import com.lukasowy.models.User;
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
	@Cacheable("addressCache")
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	@Caching(put = {
			@CachePut(value = "addressCache", key = "#address")
	})
	//@CachePut(value = "addressCache", key = "#address")
	public String addAddress(Address address) {
		String message = "";
		JSONObject jsonObject = new JSONObject();
		try {
			if (address.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}
			User user = userRepository.findOne(address.getUserId());
			address.setUser(user);
			addressRepository.save(address);
			jsonObject.put("status", "success");
			jsonObject.put("title", message + " Confirmation");
			jsonObject.put("message", "Address for "+user.getUserName() + " " + message + " successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	@CacheEvict(value = "addressCache", allEntries=true)
	public String deleteAddress(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			addressRepository.delete(id);
			jsonObject.put("message", "Address deleted");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@Override
	@Caching(evict = {
			@CacheEvict(value = "addressCache", allEntries=true)	
	})
	//@CacheEvict(value = "addressCache", allEntries=true) // replace old cache with the new
	public void refreshCache() {
	}

}
