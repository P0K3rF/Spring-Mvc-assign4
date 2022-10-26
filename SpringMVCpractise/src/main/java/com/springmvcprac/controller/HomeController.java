package com.springmvcprac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvcprac.entity.Response;
import com.springmvcprac.entity.User;
import com.springmvcprac.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService service;
	
	@GetMapping(path = {"/","/home"})
	public String index() {
		System.out.println("Index called");
		return "home";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/register")
	public @ResponseBody Response postregister(@RequestBody User user) {
		System.out.println(user);
		this.service.insertUser(user);
		try {
		return new Response("success","Succfully Registered");
		}catch(Exception e) {
			return new Response("Error",e.getMessage());
		}
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login method");
		return "login";
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public @ResponseBody Response loginCreds(@RequestBody User user)
	{
		System.out.println(user);
		if(this.service.validateUser(user))
			return new Response("Success","No Error");
		else
			return new Response("Error","Wrong Creds");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
}
