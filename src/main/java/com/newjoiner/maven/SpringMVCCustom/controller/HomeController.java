package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.newjoiner.maven.SpringMVCCustom.model.*;
import com.newjoiner.maven.SpringMVCCustom.service.*;

@Controller
public class HomeController {
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
		System.out.println("testing home page");
		return "home";
	}
	
	@RequestMapping(value="/player", method = RequestMethod.GET)
	public String listPlayers(Model model) {
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		System.out.println(players.get(0).getLastName());
		System.out.println(players);
		return "allplayers";
	}
	
	@RequestMapping(value="/savePlayer", method = RequestMethod.POST)
	public String savePlayers(@RequestParam String firstName, @RequestParam String lastName, Model model) {
		System.out.println(firstName + " " + lastName);
		playerService.savePlayer(firstName, lastName);
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		System.out.println(players.get(0).getLastName());
		System.out.println(players);
		return "allplayers";
	}
}
