package com.roles.permission.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roles.permission.entities.Role;
import com.roles.permission.entities.User;
import com.roles.permission.repository.RoleRepository;
import com.roles.permission.repository.UserRepository;
import com.roles.permission.service.AuthService;

@Service
public class AuthServiceImplementation implements AuthService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User postData(User user) {
		User u = new User();
		u.setUsername(user.getUsername());
		String pass = user.getPassword();
		String k = passwordEncoder.encode(pass);
		u.setPassword(k);
		u.setRole(new ArrayList<>(user.getRole()));
		return userRepository.save(u);
	}

	public void addRoles(int userId, int roleId) {
		User user1 = userRepository.findById(userId).orElseThrow();
		Role role1 = roleRepository.findById(roleId).orElseThrow();

		List<Role> userRole = user1.getRole();
		userRole.add(role1);
		user1.setRole(userRole);
		userRepository.save(user1);

	}

}
