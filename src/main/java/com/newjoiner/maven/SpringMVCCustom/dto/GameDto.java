package com.newjoiner.maven.SpringMVCCustom.dto;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.newjoiner.maven.SpringMVCCustom.model.Game;

public class GameDto {
	
	private int id;
	
	private Integer gameId;
	
	private Object home;
	
	private Object away;
	
	private Timestamp time;	
	

	public GameDto(Game game) {
		this.id = game.getId();
		this.gameId = game.getGameId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}


	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public Object getHome() {
		return home;
	}
	
	public Object getAway() {
		return away;
	}
	
	public Object setTeam(Game game) {
		Map<String,Object> teamObject =new HashMap<>();
		teamObject.put("team", game.getTeam());
		teamObject.put("gameNumber", game.getGameNumber());
		if(game.getLocation().equals("home")) {
			if(game.getResult()!=null) {
				teamObject.put("result", game.getResult());
			}
			if(game.getScore()!=null) {
				teamObject.put("score", game.getResult());
			}
			this.home = teamObject;
		}else if(game.getLocation().equals("away")) {
			if(game.getResult()!=null) {
				teamObject.put("result", game.getResult());
			}
			if(game.getScore()!=null) {
				teamObject.put("score", game.getResult());
			}
			this.away = teamObject;
		}
			
		return teamObject;
	}
}
