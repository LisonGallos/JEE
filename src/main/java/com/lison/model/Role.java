package com.lison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@Autowired(required=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int ID;

	@Autowired(required=true)
	@Column(name = "ADMIN")
	private int admin;
	
	@Autowired(required=true)
	@Column(name = "REFERENT")
	private int referent;

	@Autowired(required=true)
	@Column(name = "USER_M")
	private int membre;

	@Autowired(required=true)
	@Column(name = "USER_V")
	private int visiteur;
	
		
	
	public int getID() {
		return ID;
	}
	
	public int getAdmin() {
		return admin;
	}
	
	public int getReferent() {
		return referent;
	}
	
	public int getMembre() {
		return membre;
	}
	
	public int getVisiteur() {
		return visiteur;
	}
}
