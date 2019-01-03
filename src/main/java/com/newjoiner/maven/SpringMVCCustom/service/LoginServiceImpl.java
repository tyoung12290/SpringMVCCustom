package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newjoiner.maven.SpringMVCCustom.dao.UserDao;
import com.newjoiner.maven.SpringMVCCustom.model.User;


@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserDao dao;
	
	@Override
	public User findByUser(String username) {
		List<User> users = dao.findByUser(username);
		User user = users.get(0);
        return user;
    }

	
	
}


