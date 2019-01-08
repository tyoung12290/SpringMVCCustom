package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
 
@Repository("lineupDao")
public class LineupDaoImpl extends AbstractDao<Integer, Lineup> implements LineupDao {

 
    /*@Override
	@SuppressWarnings("unchecked")
    public List<Lineup> findLineupsByUser(int userId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId));
        List<Lineup> lineups = criteria.list();
        if(lineups!=null){
        	lineups.forEach(lineup ->{
        		Hibernate.initialize(lineup.getPlayers());
        	});
        }
        return lineups;
    }*/
    
    @Override
   	@SuppressWarnings("unchecked")
       public List<Lineup> findLineupsByUser(int userId) {
    	String queryStr = "FROM Lineup WHERE userId =: userId";
    	Query<Lineup> query = customQuery(queryStr);
    	query.setParameter("userId", userId);
    	List<Lineup> lineups = query.list();
           if(lineups!=null){
           	lineups.forEach(lineup ->{
           		Hibernate.initialize(lineup.getPlayers());
           	});
           }
           return lineups;
       }
    
    @Override
	public void saveLineup(Lineup lineup) {
        persist(lineup);
    }

	@Override
	public List<Lineup> findAllLineups() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}