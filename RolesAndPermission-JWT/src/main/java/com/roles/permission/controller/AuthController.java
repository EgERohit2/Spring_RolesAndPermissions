package com.roles.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entities.User;
import com.roles.permission.service.AuthService;
import com.roles.permission.service.Implementation.AuthServiceImplementation;

@RestController
@RequestMapping("/admin")
public class AuthController {

	@Autowired
	private AuthServiceImplementation authServiceImplementation;

	@Autowired
	private AuthService authService;

	@PreAuthorize("hasRole('ROLE_admin')")
	@PostMapping("/postuser")
	public String postAllData(@RequestBody User user) {
		authService.postData(user);
		return "posted successfully";
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@PostMapping("/post")
	public String post(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "role_id") int role_id) {
		this.authServiceImplementation.addRoles(user_id, role_id);
		return "Role assigned";
	}

}
