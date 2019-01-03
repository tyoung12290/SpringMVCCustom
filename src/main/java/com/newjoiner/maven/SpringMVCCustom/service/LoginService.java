package com.newjoiner.maven.SpringMVCCustom.service;

import com.newjoiner.maven.SpringMVCCustom.model.User;

public interface LoginService {

		 
	User findByUser(String username); 
	
}
