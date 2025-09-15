package com.v.demo.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v.demo.config.AccountMapper;
import com.v.demo.dto.AccountDTO;
import com.v.demo.entity.Account;
import com.v.demo.repository.AccountRepository;
import com.v.demo.service.AccountService;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repos;
	
	@Autowired
	private AccountMapper mapper;
	
	
	
	@Override
	public AccountDTO addAccount(AccountDTO acnDto) {
		
		/*
		 * First we have to convert the AccountDto into Account
		 * then we have to set all attributes
		 * then we have save that into db
		 * then we need create the object of AccontDTo
		 * and set the all value of Account with AccountDTO
		 * then we can return that
		 * 
		 * 
		 * 
		 */
		/*Account acn=new Account();
		acn.setAccountType(acnDto.getAccountType());
		acn.setPinCode(acnDto.getPinCode());
		acn.setCustomerId(acnDto.getCustomerId());
		
	Account savedAcn=	repos.save(acn);
	
	AccountDTO dto=new AccountDTO();
	dto.setAccountType(savedAcn.getAccountType());
	dto.setCustomerId(savedAcn.getCustomerId());
	dto.setPinCode(savedAcn.getPinCode());
	
		return dto;*/
		
Account acn=		  mapper.toEntity(acnDto);
    Account savedAcn=   repos.save(acn);
AccountDTO dtoRes=		  mapper.toDTo(savedAcn);
		return dtoRes;
		
	}

	@Override
	public List<AccountDTO> getAllAccount() {
	List<Account> accounts= repos.getAll();
return	 accounts.stream().map(acn-> mapper.toDTo(acn)).collect(Collectors.toList());
	}

}
