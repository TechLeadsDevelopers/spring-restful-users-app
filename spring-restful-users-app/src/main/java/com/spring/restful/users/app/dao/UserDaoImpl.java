package com.spring.restful.users.app.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.restful.users.app.common.DbQueries;
import com.spring.restful.users.app.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createUser(User user) {
		Object[] params = { user.getName(), user.getPassword(), new java.sql.Date(new Date().getTime()),
				new Timestamp(new Date().getTime()) };
		int count = jdbcTemplate.update(DbQueries.INSERT_USER, params);
		return count;
	}

	@Override
	public int[] createUser(List<User> users) {
		int count[] = jdbcTemplate.batchUpdate(DbQueries.INSERT_USER, new UserBatchSetter(users));
		return count;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = jdbcTemplate.query(DbQueries.GET_ALL_USERS, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}

	@Override
	public User getUserById(Long id) {
		Object[] params = { id };
		User user = jdbcTemplate.queryForObject(DbQueries.GET_USER_BY_ID, new BeanPropertyRowMapper<User>(User.class),
				params);
		return user;
	}

	@Override
	public int updateAccntById(User user, Long id) {
		Object[] params = { user.getName(), user.getPassword(), new Timestamp(new Date().getTime()), id };
		int count = jdbcTemplate.update(DbQueries.UPDATE_USER_BY_ID, params);
		return count;
	}

	@Override
	public int deleteUserById(Long id) {
		Object[] params = { id };
		int count = jdbcTemplate.update(DbQueries.DELETE_USER_BY_ID, params);
		return count;
	}

}
