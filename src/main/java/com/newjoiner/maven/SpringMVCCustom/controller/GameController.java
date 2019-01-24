package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newjoiner.maven.SpringMVCCustom.dto.GameDto;
import com.newjoiner.maven.SpringMVCCustom.service.GameService;

@RestController
@CrossOrigin
public class GameController {
	
	@Autowired
	GameService gameService;

	@RequestMapping(value="/game", method=RequestMethod.GET)
	public List<GameDto> getGames(@RequestParam Map<String,String> requestParams) {
		List<GameDto> games = gameService.findGames(requestParams);
		return games;
	}
	
}
