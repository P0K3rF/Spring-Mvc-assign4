package com.springmvcprac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmvcprac.entity.User;
import com.springmvcprac.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
//	@Bean
//	public PasswordEncoder encoder() {
//		
//		return encoder;
//	}
	
	public boolean insertUser(User user) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles("USER");
	this.repository.save(user);
	return true;
	}
	
	public boolean validateUser(User user) {
		if(this.repository.existsById(user.getEmail())) {
			Optional<User> optuser=this.repository.findById(user.getEmail());
			if(user.getPassword().equals(optuser.get().getPassword())) {
				return true;
			}
		}
		
		return false;
	}
}
