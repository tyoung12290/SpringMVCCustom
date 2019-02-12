package com.newjoiner.maven.SpringMVCCustom.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="player_detail")
public class PlayerDetail {

	public PlayerDetail() {};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="player_id", referencedColumnName="id")
	private Player player;
	
	@ManyToOne
	@JoinColumn(name="team_id", referencedColumnName="id")
	private Team team;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="PLAYER_DETAIL_GAME",
    			joinColumns= {@JoinColumn(name="PLAYER_DETAIL_ID", referencedColumnName="id")},
    			inverseJoinColumns= {@JoinColumn(name="GAME_ID", referencedColumnName="id")})	
    private List<Game> games;
	
	@ManyToMany(mappedBy="playerDetails")
	@JsonIgnore
	private List<Lineup> lineups;
	
	

	@Column(name="salary")
	private int salary;
	
	@Column(name="act_score",nullable = true)
	private Integer actualScore;
	
	@Column(name="proj_score")
	private Integer projectedScore;
	
	@Column(name="date")
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
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
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
	
	

	public List<Lineup> getLineups() {
		return lineups;
	}

	public void setLineups(List<Lineup> lineups) {
		this.lineups = lineups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDetail other = (PlayerDetail) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
}
