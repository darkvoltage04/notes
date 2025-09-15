package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "MyUserController", description = "Here we can get and save user")
public class UserController {
	
	
	@GetMapping("/hi")
	public String method1()
	{
		return "welcome";
	}
	
	@PostMapping("/create")
	public User save(@RequestBody User user)
	{
		return user;
	}

}
