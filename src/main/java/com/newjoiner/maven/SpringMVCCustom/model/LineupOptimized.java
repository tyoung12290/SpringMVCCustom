package com.newjoiner.maven.SpringMVCCustom.model;

import java.sql.Date;
import java.util.List;

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
@Table(name="lineup_optimized")
public class LineupOptimized {
	
	public LineupOptimized() {};
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToMany
    @JoinTable(name="LINEUP_OPTIMIZED_PLAYER_DETAIL",
    			joinColumns= {@JoinColumn(name="LINEUP_OPTIMIZED_ID", referencedColumnName="id")},
    			inverseJoinColumns= {@JoinColumn(name="PLAYER_DETAIL_ID", referencedColumnName="id")})	
    private List<PlayerDetail> playerDetails;
	
    @Column(name="date")
    private Date date;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

	public List<PlayerDetail> getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(List<PlayerDetail> playerDetails) {
        this.playerDetails = playerDetails;
    }
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		LineupOptimized other = (LineupOptimized) obj;
		if (id != other.id)
			return false;
		return true;
	}
    	
}