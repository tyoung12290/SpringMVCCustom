package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;
 
import com.newjoiner.maven.SpringMVCCustom.model.Player;
 
public interface PlayerService {
 
	Player findById(int id);
 
    List<Player> findAllPlayers(); 
     
     
}