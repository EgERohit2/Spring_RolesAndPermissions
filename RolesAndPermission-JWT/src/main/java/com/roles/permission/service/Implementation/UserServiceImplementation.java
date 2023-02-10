package com.roles.permission.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roles.permission.entities.User;
import com.roles.permission.repository.UserRepository;
import com.roles.permission.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User postData(User user) {
		User user1 = new User();
		user1.setUsername(user.getUsername());
		String pass = user.getPassword();
		String k = passwordEncoder.encode(pass);
		user1.setPassword(k);
		return userRepository.save(user1);

	}

	@Override
	public List<User> getData() throws AccessDeniedException {
		return this.userRepository.findAll();
	}

	@Override
	public void updateAll(User user, int id) {
		User user1 = userRepository.findById(id).orElseThrow();
		user1.setPassword(user.getPassword());
		user1.setUsername(user.getUsername());
		this.userRepository.save(user1);

	}

	@Override
	public void deleteAll(int id) {
		this.userRepository.deleteById(id);

	}

	@Override
	public void getById(int id) {
		this.userRepository.findById(id);

	}

}
