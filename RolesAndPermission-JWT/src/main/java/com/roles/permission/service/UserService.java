package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entities.User;

public interface UserService {

	public User postData(User user);
	
	public List<User> getData();
	
	public void updateAll(User user, int id);
	
	public void deleteAll(int id);
}
