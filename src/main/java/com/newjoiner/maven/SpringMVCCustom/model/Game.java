package com.newjoiner.maven.SpringMVCCustom.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="game_team")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="game_id")
	private Integer gameId;
	
	@Column(name="game_number")
	private Integer gameNumber;
	
	@ManyToOne
	@JoinColumn(name="team_id", referencedColumnName="id")
	private Team team;
	
	@Column(name="location")
	private String location;
	
	@Column(name="time")
	private Timestamp time;
	
	@Column(name="result")
	private Integer result;
	
	@Column(name="score")
	private Integer score;

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

	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

	

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	

}
