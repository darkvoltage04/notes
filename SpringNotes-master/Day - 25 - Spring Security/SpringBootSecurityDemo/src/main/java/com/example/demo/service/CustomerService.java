package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class CustomerService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepos;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepos.findById(username).orElseThrow(()->new UsernameNotFoundException("User Name not found"));
		
		List<SimpleGrantedAuthority> list=user.getRoles().stream().
				map(role->new SimpleGrantedAuthority("ROLE_"+user.getUserName())).collect(Collectors.toList());
		
		
		
		
		return new org.springframework.security.core.userdetails.User(
				
				user.getUserName(),
				user.getUserPassword(),
				user.isActivated(), true, true,true,
				list
		);
	}

}
