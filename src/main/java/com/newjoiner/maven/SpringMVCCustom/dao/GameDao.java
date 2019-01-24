package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.Game;
 
public interface GameDao {
	
 
		List<Game> findGames(Map<String,?> requestParams);
		
}