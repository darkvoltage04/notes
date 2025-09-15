package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/user")
	public String getUser()
	{
		return "Welcome User";
	}
	@GetMapping("/admin")
	public String getAdmin()
	{
		return "Welcome Admin";
	}

}
