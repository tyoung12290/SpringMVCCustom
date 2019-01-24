package com.newjoiner.maven.SpringMVCCustom.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newjoiner.maven.SpringMVCCustom.dao.GameDao;
import com.newjoiner.maven.SpringMVCCustom.dto.GameDto;
import com.newjoiner.maven.SpringMVCCustom.model.Game;

@Service("gameService")
@Transactional
public class GameServiceImpl implements GameService {
 
    @Autowired
    private GameDao dao;
     
    @Override
	public List<GameDto> findGames(Map<String,?> requestParams) {
    	List<Game> games = dao.findGames(requestParams);
    	Integer gameId = -1;
    	GameDto currGame = null;
    	List<GameDto> gamesDto = new ArrayList<>();
    	for (Game game : games) {
    		if(!gameId.equals(game.getGameId())) {
    			currGame = new GameDto(game);
    		}else {
    			gamesDto.add(currGame);
    		}
    		currGame.setTeam(game);
    		currGame.setTime(game.getTime());
    		gameId = game.getGameId();
    	}

/*    	List<GameDto> gamesDto = games.stream()
				.map(g-> new GameDto(g))
				.collect(Collectors.toList());*/
        return gamesDto;
    }

    
}
