package com.newjoiner.maven.SpringMVCCustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public String saveLineup(@ModelAttribute("user") User user, Model viewModel) {
		User userObj = loginService.findByUser(user.getUsername());
		viewModel.addAttribute("userId", userObj.getId());
		return "home";
	}
}
