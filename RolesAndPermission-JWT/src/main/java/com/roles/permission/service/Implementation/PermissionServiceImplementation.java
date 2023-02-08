package com.roles.permission.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roles.permission.entities.Permission;
import com.roles.permission.repository.PermissionRepository;
import com.roles.permission.service.PermissionService;
@Service
public class PermissionServiceImplementation implements PermissionService{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public Permission postData(Permission permission) {
		Permission k=new Permission();
		k.setPersmissionname(permission.getPersmissionname());
		return this.permissionRepository.save(k);
	}

	@Override
	public List<Permission> getData() {
		return this.permissionRepository.findAll();
	}

	@Override
	public void updateAll(Permission permission, int id) {
		Permission per = permissionRepository.findById( id).orElseThrow();
		per.setPersmissionname(permission.getPersmissionname());
		permissionRepository.save(per);
		
	}

	@Override
	public void deleteAll(int id) {
		this.permissionRepository.deleteById(id);
		
	}

	
	

}
