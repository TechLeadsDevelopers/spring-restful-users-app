package com.spring.restful.users.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.spring.restful.users.app.model.User;

public class UserBatchSetter implements BatchPreparedStatementSetter {

	List<User> users;

	public UserBatchSetter(List<User> users) {
		this.users = users;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setString(1, users.get(i).getName());
		ps.setString(2, users.get(i).getPassword());
		ps.setDate(3, new java.sql.Date(new Date().getTime()));
		ps.setTimestamp(4, new Timestamp(new Date().getTime()));
	}

	@Override
	public int getBatchSize() {
		int batchSize = users.size();
		return batchSize;
	}

}
