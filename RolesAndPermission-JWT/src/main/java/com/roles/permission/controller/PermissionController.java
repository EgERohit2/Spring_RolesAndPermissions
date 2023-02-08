package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entities.Permission;
import com.roles.permission.service.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/postpermission")
	public String postAllData(@RequestBody Permission permission) {
		this.permissionService.postData(permission);
		return "posted";
	}

	@GetMapping()
	public List<Permission> getAllData() {
		return this.permissionService.getData();
	}
	
	@PutMapping("/{id}")
	public String updateAllData(@RequestBody Permission permission,@PathVariable int id) {
		this.permissionService.updateAll(permission, id);
		return "updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAllData(@PathVariable int id) {
		this.permissionService.deleteAll(id);
		return "deleted";
	}
}
