package com.newjoiner.maven.SpringMVCCustom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 
@Entity
@Table(name="player")
public class Player {
	
	public Player() {}
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
 
    @Size(min=3, max=50)
    @Column(name = "first_name", nullable = false)
    private String firstName;
     
    @Size(min=3, max=50)
    @Column(name = "last_name", nullable = false)
    private String lastName;
 
    @Size(min=2, max=2)
    @Column(name = "pos", nullable = true)
    private String pos;
    
    @Size(min=3, max=3)
    @Column(name = "team", nullable = true)
    private String team;
    
	/*@OneToMany(fetch=FetchType.EAGER, mappedBy="player", targetEntity=PlayerDetail.class)
	@Where(clause="date = '2019-01-06'")
	@JsonManagedReference
	private List<PlayerDetail> playerDetails =new ArrayList<PlayerDetail>();*/
    /*public Player(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}*/
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
    public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	
/*	public List<PlayerDetail> getPlayerDetails() {
		return playerDetails;
	}

	public void setPlayerDetails(List<PlayerDetail> playerDetails) {
		this.playerDetails = playerDetails;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		Player other = (Player) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}


	
	
}