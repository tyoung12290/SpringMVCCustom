package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDao;
import com.newjoiner.maven.SpringMVCCustom.model.Player;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
 
    @Autowired
    private PlayerDao dao;
     
    public Player findById(int id) {
        return dao.findById(id);
    }
     
    public List<Player> findAllPlayers() {
        return dao.findAllPlayers();
    }
     
}
