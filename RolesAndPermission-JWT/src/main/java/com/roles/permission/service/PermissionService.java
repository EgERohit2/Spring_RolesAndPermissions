package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entities.Permission;

public interface PermissionService {

	public Permission postData(Permission permission);

	public List<Permission> getData();

	public void updateAll(Permission permission, int id);

	public void deleteAll(int id);

	public void getById(int id);
}
