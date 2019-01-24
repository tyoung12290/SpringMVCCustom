package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.dto.GameDto;
 
 
public interface GameService {
 
	List<GameDto> findGames(Map<String,?> requestParams); 
	
     
}