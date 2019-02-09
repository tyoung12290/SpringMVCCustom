package com.newjoiner.maven.SpringMVCCustom.dto;

import java.sql.Date;
import com.newjoiner.maven.SpringMVCCustom.model.Player;
import com.newjoiner.maven.SpringMVCCustom.model.Team;

public class PlayerDetailDto {
	
public PlayerDetailDto() {};
	
	
	private int id;

	private Player player;
	
	private Team team;
	
	private Object game;

	private int salary;
	
	private Integer actualScore;
	
	private Integer projectedScore;
	
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Object getGame() {
		return game;
	}

	public void setGame(Object game) {
		System.out.println(game);
		this.game = game;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Integer getActualScore() {
		return actualScore;
	}

	public void setActualScore(Integer actualScore) {
		this.actualScore = actualScore;
	}

	public Integer getProjectedScore() {
		return projectedScore;
	}

	public void setProjectedScore(Integer projectedScore) {
		this.projectedScore = projectedScore;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
