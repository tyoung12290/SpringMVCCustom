package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newjoiner.maven.SpringMVCCustom.dao.LineupDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.model.Player;

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
	public ArrayList<Player> flattenLineup(List<Lineup> lineupSlots) {
		// TODO Auto-generated method stub
		return null;
	}
    

/*	@Override
	public void saveLineup(List<Lineup> lineup, int lineupId) {
		// TODO Auto-generated method stub
		
	}*/
     
/*    @Override
    public ArrayList<Player> flattenLineup(List<Lineup> lineupSlots){
		
    	int lineupId;
    	ArrayList<Player> flatLineup = new ArrayList<Player>();
    	lineupSlots.forEach(player->{
    		flatLineup.add(player.getPlayer());
    	});
    	
    	return flatLineup;
    	
    }*/
}
