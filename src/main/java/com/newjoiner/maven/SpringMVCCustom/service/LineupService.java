package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
 
 
public interface LineupService {
 
	List<Lineup> findLineupsByUser(int userId); 
	
	List<Lineup> findOptimizedLineup(Map<String,?> requestParams); 
	
	
	Lineup findById(int lineupId); 
    
    Lineup saveLineup(Lineup lineup);
    
    void deleteLineup(int lineupId);   
    
    void updateLineup(Lineup lineup);
     
}