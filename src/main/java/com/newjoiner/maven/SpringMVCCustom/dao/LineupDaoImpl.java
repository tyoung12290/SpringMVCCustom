package com.newjoiner.maven.SpringMVCCustom.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;

@Repository("lineupDao")
public class LineupDaoImpl extends AbstractDao<Integer, Lineup> implements LineupDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Lineup findById(int id) {
		return getByKey(id);
	}

	@Override
	@SuppressWarnings("unchecked")
    public List<Lineup> findLineups(Map<String,?> requestParams) {
    	System.out.println(requestParams);
    	Query query;
    	if (requestParams.containsKey("date")) {
    		Date time = Date.valueOf((String) requestParams.get("time"));
        	query = getSession().createQuery("FROM Lineup where time >: time");
        	query.setParameter("time", time);
    	}else {
    		query = getSession().createQuery("FROM Lineup");
    	}
    	
        return query.list();
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lineup> findLineupsByUser(int userId) {
		String queryStr = "FROM Lineup WHERE userId =: userId";
		Query<Lineup> query = getSession().createQuery(queryStr);
		query.setParameter("userId", userId);
		List<Lineup> lineups = query.list();
		if (lineups != null) {
			lineups.forEach(lineup -> {
				Hibernate.initialize(lineup.getPlayerDetails());
			});
		}
		return lineups;
	}

	@Override
	public void saveLineup(Lineup lineup) {
		getSession().save(lineup);
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