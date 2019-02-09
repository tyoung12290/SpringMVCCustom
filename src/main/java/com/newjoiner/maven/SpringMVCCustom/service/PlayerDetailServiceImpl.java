package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.newjoiner.maven.SpringMVCCustom.dao.PlayerDetailDao;
import com.newjoiner.maven.SpringMVCCustom.dto.PlayerDetailDto;
import com.newjoiner.maven.SpringMVCCustom.model.Game;
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

    @Override public List<PlayerDetailDto> findAllPlayers(Map<String, ?> requestParams) {
        	List<PlayerDetail> playerDetails = dao.findAllPlayers(requestParams);
        	Integer gameId = -1;
        	
        	PlayerDetailDto currPlayerDetail = null;
        	List<PlayerDetailDto> playerDetailsDto = new ArrayList<>();
        	
        	
        	for (PlayerDetail playerDetail : playerDetails) {
        		List<String> teams = new ArrayList<>();
        		Map<String,Object> gameObject =new HashMap<>();
        		
        		currPlayerDetail = convertToDto(playerDetail);
        		for(Game game: playerDetail.getGames()) {
        			gameObject.put("id", game.getGameId());
        			teams.add(game.getTeam().getAbbr());
        		}
        		gameObject.put("matchup", String.join("@", teams));
        		currPlayerDetail.setGame(gameObject);
        		playerDetailsDto.add(currPlayerDetail);
        	}
            return playerDetailsDto;
    }
    
    private PlayerDetailDto convertToDto(PlayerDetail playerDetail) {
    	PlayerDetailDto playerDetailDto = new PlayerDetailDto();
    	playerDetailDto.setActualScore(playerDetail.getActualScore());
    	playerDetailDto.setDate(playerDetail.getDate());
    	playerDetailDto.setId(playerDetail.getId());
    	playerDetailDto.setProjectedScore(playerDetail.getProjectedScore());
    	playerDetailDto.setPlayer(playerDetail.getPlayer());
    	playerDetailDto.setSalary(playerDetail.getSalary());
    	playerDetailDto.setTeam(playerDetail.getTeam());
    	return playerDetailDto;
    }
       
}
