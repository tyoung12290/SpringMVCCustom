package com.newjoiner.maven.SpringMVCCustom.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;
 
@Repository("playerDetailDao")
public class PlayerDetailDaoImpl extends AbstractDao<Integer, PlayerDetail> implements PlayerDetailDao {
 
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	
	
    @Override
	public PlayerDetail findById(int id) {
        return getByKey(id);
    }
    @Override
	@SuppressWarnings("unchecked")
    public List<PlayerDetail> findAllPlayers(Map<String,?> requestParams) {
    	CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    	CriteriaQuery<PlayerDetail> criteriaQuery = criteriaBuilder.createQuery(PlayerDetail.class);
		Root<PlayerDetail> root = criteriaQuery.from(PlayerDetail.class);
    	String key;
    	if(!requestParams.keySet().isEmpty()) {
    		if(requestParams.containsKey("date")) {			
    			Date date = Date.valueOf((String) requestParams.get("date"));
    			criteriaQuery.where(criteriaBuilder.greaterThan(root.get("date"), date));
    			requestParams.remove("date");
    		}
        	for (int i=0 ; i< requestParams.keySet().size(); i++) {
        		key =requestParams.keySet().iterator().next();
        		//TODO handle queryParam to class type checks
        		criteriaQuery.where(criteriaBuilder.equal(root.get(key), Integer.parseInt((String) requestParams.get(key))));
        	}
		}
    	Query<PlayerDetail> query = getSession().createQuery(criteriaQuery);
    	return query.list();
    }
}