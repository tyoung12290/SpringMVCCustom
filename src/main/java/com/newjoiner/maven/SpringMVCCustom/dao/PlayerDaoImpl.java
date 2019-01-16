package com.newjoiner.maven.SpringMVCCustom.dao;

import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.Player;
 
@Repository("playerDao")
public class PlayerDaoImpl extends AbstractDao<Integer, Player> implements PlayerDao {
 
    @Override
	public Player findById(int id) {
        return getByKey(id);
    }

    
    @Override
    public void updatePlayer(Player player) {
    	saveOrUpdate(player);
    }
    
}