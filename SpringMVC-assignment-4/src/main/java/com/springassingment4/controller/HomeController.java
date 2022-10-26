package com.springassingment4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springassingment4.dao.UserRepository;
import com.springassingment4.entity.Response;
import com.springassingment4.entity.User;

@Controller
public class HomeController {
	
	@Autowired
	UserRepository repository;
	
	public HomeController() {
		System.out.println("Home controller Constructor");
	}
	
	@RequestMapping(path = {"/","/index"})
	public String index()
	{
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		System.out.println("login");
		return "login";
	}
	
	@RequestMapping(path = "/register",method = RequestMethod.GET)
	public String register()
	{
		System.out.println("register");
		return "register";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public @ResponseBody Response registeringData(@RequestBody User user)
	{	
		if(this.repository.insertUser(user))
			return new Response("Success","No Error");
		else
			return new Response("Failed","Something Went Wrong on server side");		
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public @ResponseBody Response loginCreds(@RequestBody User user)
	{
		if(this.repository.validateUser(user))
			return new Response("Success","No Error");
		else
			return new Response("Error","Wrong Creds");
	}
	

}
