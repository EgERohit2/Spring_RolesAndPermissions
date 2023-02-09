package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entities.Role;
import com.roles.permission.entities.User;
import com.roles.permission.repository.UserRepository;
import com.roles.permission.service.AuthService;
import com.roles.permission.service.Implementation.AuthServiceImplementation;

@RestController
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthServiceImplementation authServiceImplementation;

	@Autowired
	private AuthService authService;
	
	@PostMapping("/registration")
	public String postAllData(@RequestBody User user) {
		authService.postData(user);
		return "posted successfully";
	}
	
	@PostMapping("/post")
	public String post(@RequestParam(value= "user_id") int user_id,@RequestParam(value="role_id") int role_id) {
		this.authServiceImplementation.addRoles(user_id, role_id);
		return "Role assigned";
		
	}
	
}
