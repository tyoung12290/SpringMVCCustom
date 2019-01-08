package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
 
public interface LineupDao {
 
		List<Lineup> findLineupsByUser(int userId);
 
        void saveLineup(Lineup lineup);
       
    
        List<Lineup> findAllLineups();
}