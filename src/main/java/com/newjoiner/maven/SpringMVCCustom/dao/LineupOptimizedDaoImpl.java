package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.model.LineupOptimized;

@Repository("lineupOptimizedDao")
public class LineupOptimizedDaoImpl extends AbstractDao<Integer, Lineup> implements LineupOptimizedDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	@SuppressWarnings("unchecked")
    public List<LineupOptimized> findOptimizedLineups() {
    	Query query;
		query = getSession().createQuery("FROM LineupOptimized");
		query.setMaxResults(10);
    	List<LineupOptimized> lineups = query.list();
    	if (lineups != null) {
			lineups.forEach(lineup -> {
				Hibernate.initialize(lineup.getPlayerDetails());
			});
		}
        return lineups;
    }
	
}