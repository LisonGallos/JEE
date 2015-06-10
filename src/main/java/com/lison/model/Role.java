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
	@Column(name = "NOM")
	private String role;	
		
	
	public int getID() {
		return ID;
	}
	
	public String getRole(){
		return role;
	}

	public void setRole(String role){
		this.role = role;
	}
}
