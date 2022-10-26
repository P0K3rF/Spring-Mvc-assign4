package com.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springsecurity.entity.LoginUser;
import com.springsecurity.repository.LoginUserRepo;

@SpringBootApplication
public class SpringSecurityPractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPractiseApplication.class, args);
	}

	@Autowired
	LoginUserRepo loginUserRepo;
	
	@Bean
	
	public void setUp() {
		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		LoginUser u1=new LoginUser(1,"khalil",encoder.encode("123"),"ROLE_USER");
		LoginUser u2=new LoginUser(2,"pokerf",encoder.encode("123"),"ROLE_ADMIN");
		LoginUser u3=new LoginUser(3,"shayan",encoder.encode("123"),"ROLE_USER");
//		this.loginUserRepo.save(u1);
//		this.loginUserRepo.save(u2);
		this.loginUserRepo.save(u3);
	}
	
//	@Bean
//	public boolean check() {
//	LoginUser lg=	this.loginUserRepo.findByUserName("khalil").get();
//	System.out.println(lg.getPassword());
//
//	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//	PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	boolean b=	encoder.matches("123",  "{bcrypt}$2a$10$L2Im/M6mgFWtvc3luOpzpOokV34JIwPgNGmU.gI0E2z.huMfVDMuW");
//
//	System.out.println("Password matched" +b);
//	return true;
//	}
	
	
}
