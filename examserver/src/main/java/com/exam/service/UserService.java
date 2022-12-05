package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	//get user by userName
	public User getUser(String userName);

	//delete user by id
	public void deleteUser(Long userId);

	//This is a service interface

}
