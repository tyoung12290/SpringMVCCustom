package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.newjoiner.maven.SpringMVCCustom.dao.LineupDao;
import com.newjoiner.maven.SpringMVCCustom.dao.LineupOptimizedDao;
import com.newjoiner.maven.SpringMVCCustom.dao.PlayerDetailDao;
import com.newjoiner.maven.SpringMVCCustom.model.Lineup;
import com.newjoiner.maven.SpringMVCCustom.model.LineupOptimized;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;

@Service("lineupOptimizedService")
@Transactional
public class LineupOptimizedServiceImpl implements LineupOptimizedService {
 
    @Autowired
    private LineupOptimizedDao dao;
     
    @Override
	public List<LineupOptimized> findOptimizedLineups(Map<String,String> requestParams) {
        return dao.findOptimizedLineups(requestParams);
    }
        
    
}
