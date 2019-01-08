package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.ArrayList;
import java.util.List;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.model.Player;
 
 
public interface LineupService {
 
	List<Lineup> findLineupsByUser(int userId); 
    
    void saveLineup(Lineup lineup);
  
    
    ArrayList<Player> flattenLineup(List<Lineup> lineupSlots);
     
     
}