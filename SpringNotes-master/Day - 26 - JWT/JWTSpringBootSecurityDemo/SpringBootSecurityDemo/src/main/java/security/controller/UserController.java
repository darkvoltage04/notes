package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import security.dto.LoginDto;
import security.dto.UserDTO;
import security.service.UserService;
import security.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	 @Autowired

	    private AuthenticationManager authManager;
	 
	    @Autowired

	    private JwtUtil jwtUtil;
	
	@PostMapping("/register")
	public ResponseEntity<String> signUpUser(@RequestBody UserDTO dto)
	{
		 service.registerUser(dto);
		 return ResponseEntity.ok("successfully registered");
		
	}
	
	  @PostMapping("/login")

	    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {

	        Authentication auth = authManager.authenticate(

	            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
	 
	        UserDetails userDetails = (UserDetails) auth.getPrincipal();
	        String token=null;
	        if(userDetails!=null)
	        {

	         token = jwtUtil.generateToken(userDetails);
	        }

	        return ResponseEntity.ok(token);

	    }

	

}
