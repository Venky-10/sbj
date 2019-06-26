package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.UserDetails;

@Service
@Component
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public void addUser(UserDetails userDetails) {
		userRepository.save(userDetails);
	}

}
