package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;
 
public interface PlayerDetailDao {
	
    PlayerDetail findById(int id);
    
    List<PlayerDetail> findAllPlayers(Map<String,?> requestParams);
    
}