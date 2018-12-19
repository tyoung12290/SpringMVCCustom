package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.newjoiner.maven.SpringMVCCustom.model.*;
import com.newjoiner.maven.SpringMVCCustom.service.*;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	PlayerService playerService;

	@RequestMapping(value="/player", method = RequestMethod.GET)
	public String listPlayers(Model model) {
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		System.out.println(players.get(0).getLastName());
		System.out.println(players);
		return "allplayers";
	}
}
