package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newjoiner.maven.SpringMVCCustom.model.LineupOptimized;
import com.newjoiner.maven.SpringMVCCustom.service.LineupOptimizedService;

@RestController
@CrossOrigin
public class LineupOptimizedController {
	
	@Autowired
	private LineupOptimizedService lineupOptimizedService;

	@RequestMapping(value="/lineup/optimized", method=RequestMethod.GET)
	public List<LineupOptimized> getLineups(@RequestParam Map<String,String> requestParams) {
		List<LineupOptimized> lineups = lineupOptimizedService.findOptimizedLineups(requestParams);
		return lineups;
	}
	
}
