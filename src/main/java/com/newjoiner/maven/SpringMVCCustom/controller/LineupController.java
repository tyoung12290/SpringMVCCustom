package com.newjoiner.maven.SpringMVCCustom.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Controller
public class LineupController {
	
	@Autowired
	//TODO add access modifier
	PlayerService playerService;

	
	@RequestMapping(value="/lineup", method = RequestMethod.POST)
	@ResponseBody
	public String saveLineup(@RequestBody Player player, Model model) throws JsonGenerationException, JsonMappingException, IOException  {
		playerService.savePlayer(player);
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		ObjectMapper mapper = new ObjectMapper();
		String allPlayersJson = mapper.writeValueAsString(players);
		return allPlayersJson;
	}
}
