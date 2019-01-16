package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
 
 
public interface LineupService {
 
	List<Lineup> findLineupsByUser(int userId); 
    
    void saveLineup(Lineup lineup);
    
    void deleteLineup(int lineupId);   
    
    void updateLineup(Lineup lineup);
     
}