package com.lison.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "PERFORMANCE")
public class Performance {

	@Id
	@Autowired(required=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int ID;

	@Column(name = "NAME")
	private String intitule;

	@Column(name = "POINT")
	private int points;	

	@Column(name = "PERF_DT")
	private Date date_performance;

	@Autowired(required=true)
	@Column(name = "ID_MBR")
	private int id_membre;

	@Autowired(required=true)
	@Column(name = "ID_COMP")	
	private int id_competition;		

	public int getID() {
		return ID;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Date getDate_performance() {
		return date_performance;
	}

	public void setDate_performance(Date date_performance) {
		this.date_performance = date_performance;
	}
	
	public int getId_membre() {
		return id_membre;
	}

	public void setId_membre(int id_membre) {
		this.id_membre = id_membre;
	}	
	
	public int getId_competition() {
		return id_competition;
	}

	public void setId_competition(int id_competition) {
		this.id_competition = id_competition;
	}
}
