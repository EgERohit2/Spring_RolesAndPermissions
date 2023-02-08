package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entities.Role;

public interface RoleService {

	public Role postData(Role role);
	
	public List<Role> getData();
	
	public void updateAll(Role role,int id);
	
	public void deleteAll(int id);
	
}
