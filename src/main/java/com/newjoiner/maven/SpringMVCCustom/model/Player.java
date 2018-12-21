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
    
    public Player(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setName(String firstName) {
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

	@Override
    public String toString() {
        return "Player [id=" + id + ", first name=" + firstName + "last name=" + lastName + "]";
    }
     
}