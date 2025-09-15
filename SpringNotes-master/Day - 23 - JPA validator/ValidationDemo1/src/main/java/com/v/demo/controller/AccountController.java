package com.v.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v.demo.dto.AccountDTO;
import com.v.demo.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")

public class AccountController {

	
	
	@Autowired
	private AccountService service;
	
	
	@PostMapping
	public ResponseEntity<AccountDTO> addAccount( @Valid  @RequestBody  
			AccountDTO acnDto)
	{
		 AccountDTO dto=service.addAccount(acnDto);
		return ResponseEntity.status(201).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccount()
	{
		List<AccountDTO> list=service.getAllAccount();
		return ResponseEntity.ok(list);
	}
	
	
	
	
}
