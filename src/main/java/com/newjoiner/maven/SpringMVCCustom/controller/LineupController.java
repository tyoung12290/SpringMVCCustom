package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.service.LineupService;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Controller
public class LineupController {
	
	@Autowired
	//TODO add access modifier
	PlayerService playerService;
	
	@Autowired
	//TODO add access modifier
	LineupService lineupService;

	@RequestMapping(value="/lineup", method=RequestMethod.GET)
	@ResponseBody
	public List<Lineup> getLineups(@RequestParam(value="userId") int userId) {
		List<Lineup> lineups = lineupService.findLineupsByUser(userId);
		System.out.println(lineups);
		//System.out.println(lineups.get(0).getPlayers().get(0).getPlayerDetails());
		System.out.println(userId);
		//flatLineup = lineupService.flattenLineup(lineups);
		//flatLineup.forEach(player->{
		//	System.out.println(player);
		//});
		//System.out.println(flatLineup);
		//System.out.println(lineups);
		return lineups;
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String saveLineup(@RequestBody Lineup lineup) {
		System.out.println(lineup);
		lineupService.saveLineup(lineup);
		//lineupService.saveLineup(lineup);
		return  "{\"success\":200}";
	}
}
