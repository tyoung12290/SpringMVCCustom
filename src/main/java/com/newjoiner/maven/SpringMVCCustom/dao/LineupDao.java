package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
 
public interface LineupDao {
	
		Lineup findById(int lineupId);
 
		List<Lineup> findLineupsByUser(int userId);
		
		List<Lineup> findLineups(Map<String,?> requestParams);
 
        void saveLineup(Lineup lineup);
        
        void saveOrUpdate(Lineup lineup);
        
        void deleteLineup(Lineup lineup);
       
}