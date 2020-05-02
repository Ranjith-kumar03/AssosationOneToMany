package com.spring.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.model.User;
import com.spring.mongo.repository.UserRepository;

@RestController
public class FilpCartOrderManagementController {
	
	@Autowired
	private UserRepository _repo;
	
	@PostMapping("/addUser")
	public String placeOrder(@RequestBody User user)
	{
		_repo.save(user);
		return "Order Placed Sucessfully";
	}

	@GetMapping("/getUser/{name}")
	public List<User> getUser(@PathVariable String name)
	{
		
		return _repo.findByName(name);
	}
	
	@GetMapping("/getUserbyAddress/{city}")
	public List<User> getUserByAddress(@PathVariable String city)
	{
		
		return _repo.findUserByAddressCity(city);
	}
}
