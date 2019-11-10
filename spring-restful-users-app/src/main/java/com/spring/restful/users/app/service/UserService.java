package com.spring.restful.users.app.service;

import java.util.List;

import com.spring.restful.users.app.model.User;

public interface UserService {
	public User createUser(User user);
	public List<User> createUser(List<User> users);
	public List<User> getAllUsers();
	public User getUserById(Long id);
	public User updateAccntById(User user, Long id);
	public User deleteUserById(Long id);
}
