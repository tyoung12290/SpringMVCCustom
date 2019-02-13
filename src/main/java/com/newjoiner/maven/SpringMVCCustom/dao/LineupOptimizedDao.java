package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.LineupOptimized;
 
public interface LineupOptimizedDao {
	
		List<LineupOptimized> findOptimizedLineups(Map<String,String> requestParams);	
       
}