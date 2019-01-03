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

import com.google.gson.Gson;
import com.newjoiner.maven.SpringMVCCustom.model.Player;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Controller
public class PlayerController {
	
	@Autowired
	//TODO add access modifier
	PlayerService playerService;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/players", method = RequestMethod.GET)
	@ResponseBody
	public String listPlayers(Model model) {
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		Gson playerJson = new Gson();
		return playerJson.toJson(players);
	}
	
	@RequestMapping(value="/savePlayer", method = RequestMethod.POST)
	@ResponseBody
	public String savePlayers(@RequestBody Player player, Model model) throws JsonGenerationException, JsonMappingException, IOException  {
		playerService.savePlayer(player);
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		ObjectMapper mapper = new ObjectMapper();
		String allPlayersJson = mapper.writeValueAsString(players);
		return allPlayersJson;
	}
}
