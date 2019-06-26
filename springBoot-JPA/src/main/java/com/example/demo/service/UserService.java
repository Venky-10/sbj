package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@Transactional
@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User userDetails) {
		userRepository.save(userDetails);
	}

	@Override
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
		
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

//	public List<User> findAllUsers() {
//		return userRepository.findAll();
//	}

	@Override
	public Page<User> findAll(PageRequest pageRequest) {
		return userRepository.findAll(pageRequest);
	}

}
