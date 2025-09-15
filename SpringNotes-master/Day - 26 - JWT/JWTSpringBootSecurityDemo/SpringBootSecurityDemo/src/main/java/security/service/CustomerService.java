package security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import security.entity.User;
import security.repository.UserRepository;
@Service
public class CustomerService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepos;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		
		System.out.println("hi");
	User user=userRepos.findById(userName).orElseThrow(()->new UsernameNotFoundException("User Name not found"));
		//User user=userRepos.getById(userName);
		System.out.println(user);
		List<SimpleGrantedAuthority> authorities=user.getRoles().stream().
				map(role->new SimpleGrantedAuthority("ROLE_"+role.getRoleName())).collect(Collectors.toList());
		
		
		
		
	UserDetails d= new org.springframework.security.core.userdetails.User(
				
				user.getUserName(),
				user.getUserPassword(),
				user.isActivated(), true, true,true,
				authorities
		);
	System.out.println(d.getUsername() + " "+d.getPassword());
	return d;

	}

}
