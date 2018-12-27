package com.newjoiner.maven.SpringMVCCustom.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="lineup")
public class Lineup {
	
	public Lineup() {}
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
 
    @Column(name = "pg1", nullable = false)
    private String pg1;
     

    @Column(name = "pg2", nullable = false)
    private String pg2;
    
    @Column(name = "sg1", nullable = false)
    private String sg1;
    
    @Column(name = "sg2", nullable = false)
    private String sg2;
    
    @Column(name = "sf1", nullable = false)
    private String sf1;
    
    @Column(name = "sf2", nullable = false)
    private String sf2;
    
    @Column(name = "pf1", nullable = false)
    private String pf1;
    
    @Column(name = "pf2", nullable = false)
    private String pf2;
    
    @Column(name = "c", nullable = false)
    private String c;
    
    @Column(name="date", nullable = false)
    private Date date;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

	public String getPg1() {
		return pg1;
	}

	public void setPg1(String pg1) {
		this.pg1 = pg1;
	}

	public String getPg2() {
		return pg2;
	}

	public void setPg2(String pg2) {
		this.pg2 = pg2;
	}

	public String getSg1() {
		return sg1;
	}

	public void setSg1(String sg1) {
		this.sg1 = sg1;
	}

	public String getSg2() {
		return sg2;
	}

	public void setSg2(String sg2) {
		this.sg2 = sg2;
	}

	public String getSf1() {
		return sf1;
	}

	public void setSf1(String sf1) {
		this.sf1 = sf1;
	}

	public String getSf2() {
		return sf2;
	}

	public void setSf2(String sf2) {
		this.sf2 = sf2;
	}

	public String getPf1() {
		return pf1;
	}

	public void setPf1(String pf1) {
		this.pf1 = pf1;
	}

	public String getPf2() {
		return pf2;
	}

	public void setPf2(String pf2) {
		this.pf2 = pf2;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	@Override
	public String toString() {
		return "Lineup [id=" + id + ", pg1=" + pg1 + ", pg2=" + pg2 + ", sg1=" + sg1 + ", sg2=" + sg2 + ", sf1=" + sf1
				+ ", sf2=" + sf2 + ", pf1=" + pf1 + ", pf2=" + pf2 + ", c=" + c + ", date=" + date + "]";
	}
 
    

	
}