package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.newjoiner.maven.SpringMVCCustom.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findByUser(String username) {
		Query query = customQuery("FROM User WHERE username=:username ORDER BY id asc");
		query.setParameter("username", username);
        return query.list();
    }
}
