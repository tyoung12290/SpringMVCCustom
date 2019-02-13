package com.newjoiner.maven.SpringMVCCustom.service;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.LineupOptimized;


 
 
public interface LineupOptimizedService {
 
	List<LineupOptimized> findOptimizedLineups(Map<String,String> requestParams); 
	

     
}