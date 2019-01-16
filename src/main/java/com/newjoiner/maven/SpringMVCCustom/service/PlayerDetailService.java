package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;
 
public interface PlayerDetailService {
 
	PlayerDetail findById(int id);
   
	List<PlayerDetail> findAllPlayers(Map<String,?> requestParams); 
     
}