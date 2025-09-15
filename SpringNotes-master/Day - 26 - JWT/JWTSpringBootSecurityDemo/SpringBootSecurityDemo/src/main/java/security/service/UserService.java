package security.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import security.dto.UserDTO;
import security.entity.Role;
import security.entity.User;
import security.repository.RolesRepository;
import security.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private RolesRepository rolesRepos;
	
	@Autowired
	private PasswordEncoder encoder;

public User registerUser(UserDTO dto)
{

	User user=new User();
	user.setUserName(dto.getUserName());
	user.setUserPassword(encoder.encode(dto.getUserPassword()));
	user.setActivated(true);
	
	Set<Role> roles=dto.getRoleNames().stream().
			map(roleNames->  rolesRepos.findById(roleNames).
					orElseThrow(()->new RuntimeException("role name not found")))
			.collect(Collectors.toSet());
	
	user.setRoles(roles);
	return userRepos.save(user);
	
}
	
	
	

}
