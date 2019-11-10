package com.spring.restful.users.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.users.app.common.UserURIs;
import com.spring.restful.users.app.model.User;
import com.spring.restful.users.app.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value=UserURIs.USER_API_ROOT,method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		user=service.createUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@RequestMapping(value=UserURIs.USER_API_ROOT_BATCH,method=RequestMethod.POST)
	public ResponseEntity<List<User>> createBatchUsers(@RequestBody List<User> users){
		users=service.createUser(users);
		return new ResponseEntity<List<User>>(users,HttpStatus.CREATED);
	}
	
	@RequestMapping(value=UserURIs.USER_API_URI_BY_ID,method=RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") String id){
		User user=service.getUserById(Long.valueOf(id));
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@RequestMapping(value=UserURIs.USER_API_ROOT,method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=service.getAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value=UserURIs.USER_API_URI_BY_ID,method=RequestMethod.PUT)
	public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable("id") String id){
		user=service.updateAccntById(user, Long.valueOf(id));
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value=UserURIs.USER_API_URI_BY_ID, method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUserById(@PathVariable("id") String id){
		User user=service.deleteUserById(Long.valueOf(id));
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
