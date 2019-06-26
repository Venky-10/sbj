package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.UserServiceException;

@CrossOrigin
@RestController
public class UserController {
//	Map<String,User> user;

	@Autowired
	IUserService userService;
	
//	@GetMapping("/")
//	public String get() {
//		return "index";
//	}

	@CrossOrigin
	@GetMapping("/fetch")
	public Page<User> showPage(@Valid @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize) {
		return userService.findAll(PageRequest.of(page, pageSize));
	}
//	@GetMapping("/fetch")
//	public List<User> showPage() {
//		return userService.findAllUsers();
//	}

	@PostMapping("/save")
	public   ResponseEntity<User> addUser(@Valid @RequestBody User userDetails) {
			userService.addUser(userDetails);
			  return new ResponseEntity<User>(userDetails, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{id}")
	public Optional<User> getUser(@Valid @PathVariable("id") int id) {
//		if(true)throw new UserServiceException("A User service Exception is Thrown");
		
//		if(user.containsKey(id)) {
//			return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
			return userService.getUser(id);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "OK";
	}

}
