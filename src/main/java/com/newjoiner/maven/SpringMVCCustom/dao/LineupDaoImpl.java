package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
 
@Repository("lineupDao")
public class LineupDaoImpl extends AbstractDao<Integer, Lineup> implements LineupDao {
   
	@Override
	public Lineup findById(int id) {
        return getByKey(id);
    }

    @Override
   	@SuppressWarnings("unchecked")
       public List<Lineup> findLineupsByUser(int userId) {
    	String queryStr = "FROM Lineup WHERE userId =: userId";
    	Query<Lineup> query = customQuery(queryStr);
    	query.setParameter("userId", userId);
    	List<Lineup> lineups = query.list();
           if(lineups!=null){
           	lineups.forEach(lineup ->{
           		Hibernate.initialize(lineup.getPlayerDetails());
           	});
           }
           return lineups;
       }
    
    @Override
	public void saveLineup(Lineup lineup) {
        save(lineup);
    }
    
    @Override
	public void saveOrUpdate(Lineup updated_lineup) {
    	Lineup lineup = findById(updated_lineup.getId());
    	lineup.setPlayerDetails(updated_lineup.getPlayerDetails());
    }
    
    @Override
	public void deleteLineup(Lineup lineup) {
        delete(lineup);
    }
    
}