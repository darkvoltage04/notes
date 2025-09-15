package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> signUpUser(@RequestBody UserDTO dto)
	{
		 service.registerUser(dto);
		 return ResponseEntity.ok("successfully registered");
		
	}
	
	

}
