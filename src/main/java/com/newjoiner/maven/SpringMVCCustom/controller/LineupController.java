package com.newjoiner.maven.SpringMVCCustom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.service.LineupService;

@RestController
@CrossOrigin
public class LineupController {
	
	@Autowired
	private LineupService lineupService;

	@RequestMapping(value="/lineup", method=RequestMethod.GET)
	public List<Lineup> getLineups(@RequestParam(value="userId") int userId) {
		List<Lineup> lineups = lineupService.findLineupsByUser(userId);
		return lineups;
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Lineup saveLineup(@RequestBody Lineup lineup) {
		lineupService.saveLineup(lineup);
		return  lineup;
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.PUT)
	public Lineup updateLineup(@RequestBody Lineup lineup) {
		lineupService.updateLineup(lineup);
		return  lineup;
	}
	
	@RequestMapping(value="/lineup/{lineupId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLineup(@PathVariable int lineupId) {
		lineupService.deleteLineup(lineupId);
		if(lineupService.findById(lineupId) == null){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
