package com.v.demo.service;

import java.util.List;

import com.v.demo.dto.AccountDTO;

public interface AccountService {
	
	
	public  AccountDTO addAccount(AccountDTO acnDto);
	public List<AccountDTO> getAllAccount();

}
