package com.roles.permission.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roles.permission.entities.Role;
import com.roles.permission.entities.User;
import com.roles.permission.repository.RoleRepository;
import com.roles.permission.service.RoleService;
@Service
public class RoleServiceImplementation implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role postData(Role role) {
		Role role1 = new Role();
		role1.setRolename(role.getRolename());
		role1.setPermission(new ArrayList<>(role.getPermission()));
		return roleRepository.save(role1);
	}

	@Override
	public List<Role> getData() {
		return roleRepository.findAll();
	}

	@Override
	public void updateAll(Role role, int id) {
		Role role1 = roleRepository.findById(id).orElseThrow();
		role1.setRolename(role.getRolename());
		role1.setPermission(role.getPermission());
		this.roleRepository.save(role1);
		
	}

	@Override
	public void deleteAll(int id) {
		this.roleRepository.deleteById(id);
		
	}

	

}
