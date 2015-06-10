package com.lison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "VALIDE")
public class Valide {

	@Id
	@Autowired(required=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int ID;

	@Autowired(required=true)
	@Column(name = "NOM")
	private String valide;	
		
	
	public int getID() {
		return ID;
	}
	
	public String getValide(){
		return valide;
	}

	public void setValide(String valide){
		this.valide = valide;
	}
}
