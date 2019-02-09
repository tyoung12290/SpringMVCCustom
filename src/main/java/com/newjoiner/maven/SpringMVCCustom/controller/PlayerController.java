package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.maven.SpringMVCCustom.dto.PlayerDetailDto;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerDetailService;

@Controller
public class PlayerController {
	
	@Autowired
	PlayerDetailService playerDetailService;
	
	
	@RequestMapping(value="/players", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public List<PlayerDetailDto> getPlayers(@RequestParam Map<String,String> requestParams) {
		return playerDetailService.findAllPlayers(requestParams);
	}
	
	
}
