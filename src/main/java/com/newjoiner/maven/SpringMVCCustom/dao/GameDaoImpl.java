package com.newjoiner.maven.SpringMVCCustom.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.Game;
 
@Repository("gameDao")
public class GameDaoImpl extends AbstractDao<Integer, Game> implements GameDao {
   
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	@SuppressWarnings("unchecked")
    public List<Game> findGames(Map<String,?> requestParams) {
    	Query query;
    	if (requestParams.containsKey("date")) {
    		Date date = Date.valueOf((String) requestParams.get("date"));
    		query = getSession().createQuery("FROM Game where time >: date");
        	query.setParameter("date", date);
    	}else {
    		query = getSession().createQuery("FROM Game");
    	}
    	
        return query.list();
    }
}