package com.newjoiner.maven.SpringMVCCustom.dao;

import java.util.List;
import com.newjoiner.maven.SpringMVCCustom.model.LineupOptimized;
 
public interface LineupOptimizedDao {
	
		List<LineupOptimized> findOptimizedLineups();	
       
}