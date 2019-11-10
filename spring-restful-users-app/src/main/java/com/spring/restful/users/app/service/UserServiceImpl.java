package com.spring.restful.users.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restful.users.app.dao.UserDao;
import com.spring.restful.users.app.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public User createUser(User user) {
		int count=dao.createUser(user);
		return user;
	}

	@Override
	public List<User> createUser(List<User> users) {
		int count[]=dao.createUser(users);
		return users;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users=dao.getAllUsers();
		return users;
	}

	@Override
	public User getUserById(Long id) {
		User user=dao.getUserById(id);
		return user;
	}

	@Override
	public User updateAccntById(User user, Long id) {
		int count=dao.updateAccntById(user, id);
		return user;
	}

	@Override
	public User deleteUserById(Long id) {
		int count=dao.deleteUserById(id);
		User user=new User();
		user.setId(id);
		return user;
	}

}
