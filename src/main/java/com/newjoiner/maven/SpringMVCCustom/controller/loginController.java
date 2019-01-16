package com.newjoiner.maven.SpringMVCCustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newjoiner.maven.SpringMVCCustom.model.User;
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
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ResponseEntity<User> getUser(@RequestBody User user) {
		System.out.println(user);
		user = loginService.findByUser(user.getUsername());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
