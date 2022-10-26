package com.springassingment4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springassingment4.entity.User;

@Repository
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertUser(User user) {
		try {
			String query = "insert into user values(?,?,?)";
			this.jdbcTemplate.update(query, user.getEmail(), user.getUsername(), user.getPassword());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateUser(User user) {

		try {
		String sql = "select password from user where email=?";
		String password = jdbcTemplate.queryForObject(sql, String.class, user.getEmail());
		if (password != null && password.equals(user.getPassword())) {
			return true;
		}
		}catch(Exception e) {
			return false;
		}
		return false;
	}

}
