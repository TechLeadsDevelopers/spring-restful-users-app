package com.spring.restful.users.app.dao;

import java.util.List;

import com.spring.restful.users.app.model.User;

public interface UserDao {
	public int createUser(User user);
	public int[] createUser(List<User> users);
	public List<User> getAllUsers();
	public User getUserById(Long id);
	public int updateAccntById(User user, Long id);
	public int deleteUserById(Long id);
	
}
