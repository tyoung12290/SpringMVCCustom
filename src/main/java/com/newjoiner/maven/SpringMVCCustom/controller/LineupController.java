package com.newjoiner.maven.SpringMVCCustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.newjoiner.maven.SpringMVCCustom.model.User;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Controller
public class LineupController {
	
	@Autowired
	//TODO add access modifier
	PlayerService playerService;

	@RequestMapping(value="/lineup", method=RequestMethod.GET)
	public String getLineup() {
		return "lineups";
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.POST)
	public String saveLineup(@ModelAttribute("user") User user, Model viewModel) {
		viewModel.addAttribute("username", user.getUsername());
		return "home";
	}
}
