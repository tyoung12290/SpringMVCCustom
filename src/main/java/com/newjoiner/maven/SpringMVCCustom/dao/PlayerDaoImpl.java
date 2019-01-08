package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.query.Query;
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
	@SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
    	Query query = customQuery("FROM Player");
        return query.list();
    }
    
    @Override
	public void savePlayer(Player player) {
        persist(player);
    }
}