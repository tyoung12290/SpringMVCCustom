package com.newjoiner.maven.SpringMVCCustom.model;

import java.util.List;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
 
public interface PlayerDao {
 
    Player findById(int id);
     
    List<Player> findAllPlayers();
 
 
}