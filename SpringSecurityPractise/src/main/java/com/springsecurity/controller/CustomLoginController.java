package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomLoginController {

	@GetMapping("/customlogin")
	public String customLogin() {
		return "customlogin";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	@GetMapping("/change-password")
	public String changePassword() {
		return "changepassword";
	}
	

}
