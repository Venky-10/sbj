package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.model.User;

public interface IUserService {

	public void addUser(User userDetails);
	public Optional<User> getUser(int id);
	public void delete(int id);
	public Page<User> findAll(PageRequest pageRequest);
//	public List<User> findAllUsers();
}
