package com.newjoiner.maven.SpringMVCCustom.dao;


import java.io.Serializable;
 
import java.lang.reflect.ParameterizedType;

import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
    
    public void save(T entity) {
    	getSession().save(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }
     
    protected CriteriaBuilder builder(){
        return getSession().getCriteriaBuilder();
    }
    
    
    protected Query customQuery(String query) {
    	return getSession().createQuery(query);
    }
    
}
	
