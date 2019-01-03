package com.newjoiner.maven.SpringMVCCustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newjoiner.maven.SpringMVCCustom.service.LoginService;


@Controller
public class loginController {

	
	//TODO add access modifier
	@Autowired
	LoginService loginService;

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String loginScreen()  {
		return "login";
	}
	
	@RequestMapping(value="/user/{user}", method = RequestMethod.GET)
	public String login(@PathVariable(value="user") String username)  {
		System.out.println(username);
		return "redirect:/lineup/";
	}
}
