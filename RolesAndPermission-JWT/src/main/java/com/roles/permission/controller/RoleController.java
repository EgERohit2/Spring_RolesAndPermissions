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

import com.roles.permission.entities.Role;
import com.roles.permission.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PreAuthorize("hasRole('ROLE_admin')")
	@PostMapping("/postrole")
	public String postData(@RequestBody Role role) {
		this.roleService.postData(role);
		return "posted";
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@GetMapping()
	public List<Role> getAllData() {
		return this.roleService.getData();

	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@PutMapping("/{id}")
	public String updateAllData(@RequestBody Role role, @PathVariable int id) {
		this.roleService.updateAll(role, id);
		return "updated";
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@DeleteMapping("/{id}")
	public String deleteAllData(@PathVariable int id) {
		this.roleService.deleteAll(id);
		return "deleted";
	}

	@GetMapping("/{id}")
	public void getDataById(@PathVariable int id) {
		this.roleService.getById(id);
	}

}
