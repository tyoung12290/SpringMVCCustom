package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.newjoiner.maven.SpringMVCCustom.dao.PlayerDetailDao;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;

@Service("playerDetailService")
@Transactional
public class PlayerDetailServiceImpl implements PlayerDetailService {
 
    @Autowired
    private PlayerDetailDao dao;
     
    @Override
	public PlayerDetail findById(int id) {
        return dao.findById(id);
    }

    @Override public List<PlayerDetail> findAllPlayers(Map<String, ?> requestParams) {
    	 return dao.findAllPlayers(requestParams);
    }
       
}
