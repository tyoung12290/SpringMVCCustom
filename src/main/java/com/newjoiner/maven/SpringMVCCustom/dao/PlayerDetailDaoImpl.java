package com.newjoiner.maven.SpringMVCCustom.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.newjoiner.maven.SpringMVCCustom.dao.AbstractDao;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;
 
@Repository("playerDetailDao")
public class PlayerDetailDaoImpl extends AbstractDao<Integer, PlayerDetail> implements PlayerDetailDao {
 
    @Override
	public PlayerDetail findById(int id) {
        return getByKey(id);
    }
    @Override
	@SuppressWarnings("unchecked")
    public List<PlayerDetail> findAllPlayers(Map<String,?> requestParams) {
    	System.out.println(requestParams);
    	Query query;
    	if (requestParams.containsKey("date")) {
    		Date date = Date.valueOf((String) requestParams.get("date"));
        	query = customQuery("FROM PlayerDetail where date =: date");
        	query.setParameter("date", date);
    	}else {
    		query = customQuery("FROM PlayerDetail");
    	}
    	
        return query.list();
    }
}