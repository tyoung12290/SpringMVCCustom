package com.newjoiner.maven.SpringMVCCustom.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    public List<LineupOptimized> findOptimizedLineups(Map<String,String> requestParams) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    	CriteriaQuery<LineupOptimized> criteriaQuery = criteriaBuilder.createQuery(LineupOptimized.class);
		Root<LineupOptimized> root = criteriaQuery.from(LineupOptimized.class);
    	String key;
    	Integer limit = null;
    	Date date = null;
    	if(!requestParams.keySet().isEmpty()) {
    		if(requestParams.containsKey("date")) {	
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(requestParams.get("date"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
    			criteriaQuery.where(criteriaBuilder.equal(root.get("date"), date));
    			requestParams.remove("date");
    		}
    		if(requestParams.containsKey("limit")) {			
    			limit = Integer.parseInt(requestParams.get("limit"));
    			requestParams.remove("limit");
    		}
        	for (int i=0 ; i< requestParams.keySet().size(); i++) {
        		key =requestParams.keySet().iterator().next();
        		//TODO handle queryParam to class type checks
        		criteriaQuery.where(criteriaBuilder.equal(root.get(key), Integer.parseInt(requestParams.get(key))));
        	}
		}
    	Query<LineupOptimized> query = getSession().createQuery(criteriaQuery);
    	if(limit != null){
    		query.setMaxResults(limit);
    	}
    	List<LineupOptimized> lineups = query.list();
    	if (lineups != null) {
			lineups.forEach(lineup -> {
				Hibernate.initialize(lineup.getPlayerDetails());
			});
		}
        return lineups;
    }
	
}