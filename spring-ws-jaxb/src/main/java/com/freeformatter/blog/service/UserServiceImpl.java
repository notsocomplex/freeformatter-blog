package com.freeformatter.blog.service;

import org.springframework.stereotype.Service;

import com.freeformatter.blog.jaxb.CreateUserRequest;

// The @Service stereotype annotation will be picked up by a 
// component-scan in the configs
@Service
public class UserServiceImpl implements UserService {

	// Bogus implementation, just return a long
	@Override
	public long createUser(CreateUserRequest request) {
		return System.currentTimeMillis();
	}

}
