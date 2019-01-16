package com.newjoiner.maven.SpringMVCCustom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.newjoiner.maven.SpringMVCCustom.dao.PlayerDao;
import com.newjoiner.maven.SpringMVCCustom.model.Player;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
 
    @Autowired
    private PlayerDao dao;
     
    @Override
	public Player findById(int id) {
        return dao.findById(id);
    }
    
    @Override
    public void updatePlayer(Player player) {
    	dao.updatePlayer(player);
    }
        
}
