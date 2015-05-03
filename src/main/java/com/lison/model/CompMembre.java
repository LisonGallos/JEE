package com.lison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "REL_COMP_MBR")
public class CompMembre {

	@Id
	@Autowired(required=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int ID;
	
	@Autowired(required=true)
	@Column(name = "ID_MBR")
	private int id_membre;
	
	@Autowired(required=true)
	@Column(name = "ID_COMP")
	private int id_competition;
	
	
	public int getID() {
		return ID;
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
