package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public String listPlayers(Model model) throws JsonProcessingException {
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		ObjectMapper mapper = new ObjectMapper();
		String playerJson = mapper.writeValueAsString(players);
		return playerJson;
	}
	
	@RequestMapping(value="/savePlayer", method = RequestMethod.POST)
	@ResponseBody
	public String savePlayers(@RequestBody Player player, Model model) throws JsonProcessingException {
		playerService.savePlayer(player);
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players",players);
		ObjectMapper mapper = new ObjectMapper();
		String allPlayersJson = mapper.writeValueAsString(players);
		return allPlayersJson;
	}
}
