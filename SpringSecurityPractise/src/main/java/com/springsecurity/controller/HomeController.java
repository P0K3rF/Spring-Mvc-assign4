package com.springsecurity.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.service.LoginUserService;

@RestController
public class HomeController {
	
	@Autowired
	LoginUserService loginUserService;
	
	@GetMapping("/")
	public @ResponseBody String home() {
		return "<h1>Welcome</h1>";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user(Principal p) {
		return "<h1>Welcome User</h1>" + p.getName().toString() ;
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin(Principal p) {
		return "<h1>Welcome Admin</h1>" + p.getName().toString();
	}
	
	@PostMapping("/change-password")
	public String changePassword(HttpServletRequest req) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String username=req.getParameter("username"); 
		String oldpassword=req.getParameter("oldpassword");
	    String newpassword=req.getParameter("newpassword");
	    System.out.println(username + "  " + oldpassword + " " + newpassword);
	    if(loginUserService.changePassword(username, oldpassword, encoder.encode(newpassword)))
	         return "Password changed";
		return "Password mismatch or username not found";
	}
	
}
