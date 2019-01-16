package com.newjoiner.maven.SpringMVCCustom.dao;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
 
public interface PlayerDao {
	
    Player findById(int id);
    
    void updatePlayer(Player player);
    
}