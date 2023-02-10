package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.dto.SuccessResponseDto;
import com.roles.permission.entities.User;
import com.roles.permission.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/registration")
	public ResponseEntity<?> postAllData(@RequestBody User user) {
		this.userService.postData(user);
		return new ResponseEntity<>(new SuccessResponseDto("posted", "succeded", null), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@GetMapping()
	public List<User> getAllData() {
		return this.userService.getData();
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAllData(@RequestBody User user, @PathVariable int id) {
		this.userService.updateAll(user, id);
		return new ResponseEntity<>(new SuccessResponseDto("Updated", "succeeded", null), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAllData(@PathVariable int id) {
		this.userService.deleteAll(id);
		return new ResponseEntity<>(new SuccessResponseDto("deleted", "successfully", null), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@GetMapping("/{id}")
	public ResponseEntity<?> getDataById(@PathVariable int id) {
		this.userService.getById(id);
		return new ResponseEntity<>(new SuccessResponseDto("fetched", "succeeded", null), HttpStatus.CREATED);
	}

}
