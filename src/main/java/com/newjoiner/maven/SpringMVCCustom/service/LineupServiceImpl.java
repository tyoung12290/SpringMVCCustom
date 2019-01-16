package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newjoiner.maven.SpringMVCCustom.dao.LineupDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;

@Service("lineupService")
@Transactional
public class LineupServiceImpl implements LineupService {
 
    @Autowired
    private LineupDao dao;
     
    @Override
	public List<Lineup> findLineupsByUser(int userId) {
        return dao.findLineupsByUser(userId);
    }
    
    @Override
	public void saveLineup(Lineup lineup){
    	dao.saveLineup(lineup);
    }
    
    @Override
	public void updateLineup(Lineup lineup){
    	//lineup.getPlayers();

    	dao.saveOrUpdate(lineup);

    }
    //check for actual deletion
    @Override
	public void deleteLineup(int lineupId){
    	Lineup lineup = dao.findById(lineupId);
    	dao.deleteLineup(lineup);
    }
    
}
