package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.Criteria;
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
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }
    
    @Override
	public void savePlayer(Player player) {
        persist(player);
    }
}