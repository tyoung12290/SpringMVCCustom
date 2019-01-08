package com.newjoiner.maven.SpringMVCCustom.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="lineup")
public class Lineup {
	
	public Lineup() {};
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="user_id")
	private int userId;
 
	@ManyToMany(cascade= CascadeType.MERGE)
    @JoinTable(name="LINEUP_PLAYER",
    			joinColumns= {@JoinColumn(name="LINEUP_ID")},
    			inverseJoinColumns= {@JoinColumn(name="PLAYER_ID")})	
    private List<Player> players = new ArrayList<Player>();
    
    
   /* @Column(name="salary")
    private int salary;
    
    @Column(name="score")
    private int score;*/
	
    @Column(name="date")
    private Date date;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + userId;
		return result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lineup other = (Lineup) obj;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lineup [id=" + id + ", userId=" + userId + ", players=" + getPlayers() + "]";
	}
    
	

	
}