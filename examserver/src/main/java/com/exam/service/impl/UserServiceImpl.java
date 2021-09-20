package com.exam.service.impl;

import java.util.Optional;
import java.util.Set;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local = this.userRepository.findByUsername(user.getUsername());

		if (local != null) {
			logger.info("User Already Exists!!");
			throw new Exception("User Alredy Exists!!");
		} else {
			// create a new user
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);

		}
		return local;
	}

	//getting user by userName
	@Override
	public User getUser(String userName) {
		return this.userRepository.findByUsername(userName);
	}

	//delete user by id
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
}
