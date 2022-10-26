package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.LoginUser;
import com.springsecurity.repository.LoginUserRepo;

@Service
public class LoginUserService {
	@Autowired
	LoginUserRepo loginUserRepo;
	
	public boolean changePassword(String username,String oldPassword,String newPassword) {
		if(loginUserRepo.findByUserName(username).get()!=null) {
			LoginUser log=loginUserRepo.findByUserName(username).get();
			PasswordEncoder bc=	PasswordEncoderFactories.createDelegatingPasswordEncoder();
			if(bc.matches(oldPassword, log.getPassword())) {	
				System.out.println("Patterm matches");
				log.setPassword(newPassword);
				this.loginUserRepo.save(log);
				return true;
			}else {
				return false;
			}
		}else {
				return false;
			}
	}
}
