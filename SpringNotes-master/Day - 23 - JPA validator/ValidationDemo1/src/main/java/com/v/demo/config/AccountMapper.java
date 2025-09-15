package com.v.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.v.demo.dto.AccountDTO;
import com.v.demo.entity.Account;

@Component
public class AccountMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Account toEntity(AccountDTO dto)
	{
		return modelMapper.map(dto, Account.class);
	}
	
	public AccountDTO toDTo(Account entity)
	{
		return modelMapper.map(entity, AccountDTO.class);
	}
	
	
	
	

}
