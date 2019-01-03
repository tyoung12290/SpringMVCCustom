package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.newjoiner.maven.SpringMVCCustom.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findByUser(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq(username, username));
		criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
}
