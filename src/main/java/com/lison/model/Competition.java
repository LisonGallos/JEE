package com.lison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "COMPETITION")
public class Competition {

	@Id
	@Autowired(required=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String nom;

	@Column(name = "POINT")
	private int points;

	//@ManyToMany
	//private Collection<Membre> membres;

/*
	public Collection<Membre> setMembres() {
		return membres;
	}

	public void setMembres(Collection<Membre> membres) {
		this.membres = membres;
	}
	// @ManyToMany
	// Ne pas oublier le mapped by et le nom de la classe avec laquelle il faut
	// mapper
	private Collection<Performance> performances;

	public Collection<Performance> getPerformances() {
		return performances;
	}

	public void setPerformances(Collection<Performance> performances) {
		this.performances = performances;
	}
*/

	public int getID() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
