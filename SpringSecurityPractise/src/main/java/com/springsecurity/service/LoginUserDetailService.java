package com.springsecurity.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.LoginUser;
import com.springsecurity.repository.LoginUserRepo;

@Service
public class LoginUserDetailService implements UserDetailsService{

	@Autowired
	LoginUserRepo loginUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<LoginUser> luser=loginUserRepo.findByUserName(username);
//		return luser.map(LoginUserDetail::new).get();
		return luser.map(user->new User(user.getUserName(), user.getPassword(),
				Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList())
				)).get();
	}

}
