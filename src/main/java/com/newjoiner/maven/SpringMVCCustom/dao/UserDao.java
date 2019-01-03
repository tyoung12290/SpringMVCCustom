package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;

import com.newjoiner.maven.SpringMVCCustom.model.User;

public interface UserDao {

	List<User> findByUser(String username);
}
