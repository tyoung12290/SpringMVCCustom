package com.newjoiner.maven.SpringMVCCustom.service;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
 
public interface PlayerService {
 
	Player findById(int id);
    
    void updatePlayer(Player player);
     
     
}