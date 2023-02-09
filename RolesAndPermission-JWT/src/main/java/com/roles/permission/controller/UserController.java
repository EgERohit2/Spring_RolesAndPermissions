package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entities.User;
import com.roles.permission.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/postuser")
	public String postAllData(@RequestBody User user) {
		this.userService.postData(user);
		return "posted";
	}

	@PreAuthorize("hasRole('ROLE_payroll')")
	// @PreAuthorize("hasAuthority('weekoff')")
	@GetMapping()
	public List<User> getAllData() {
		return this.userService.getData();
	}

	@PutMapping("/{id}")
	public String updateAllData(@RequestBody User user, @PathVariable int id) {
		this.userService.updateAll(user, id);
		return "updated";
	}

	@DeleteMapping("/{id}")
	public String deleteAllData(@PathVariable int id) {
		this.userService.deleteAll(id);
		return "deleted";
	}

}
