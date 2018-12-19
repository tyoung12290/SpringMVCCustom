package com.newjoiner.maven.SpringMVCCustom.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
 
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

 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", first name=" + firstName + "last name=" + firstName + "]";
    }
     
}