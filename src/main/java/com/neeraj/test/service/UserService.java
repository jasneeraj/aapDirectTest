package com.neeraj.test.service;

import java.util.List;

import com.neeraj.test.model.User;



public interface UserService {
	
	User findById(String id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(String id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
