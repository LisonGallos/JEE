package com.lison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_MBR")
	private Membre membre;
	
	@Autowired(required=true)
	@Column(name = "IDTMP")
	private int id_tmp;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_COMP")
	private Competition competition;

	
	public int getID() {
		return ID;
	}
	
	public Membre getmembre() {
		return membre;
	}

	public void setmembre(Membre membre) {
		this.membre = membre;
	}
	
	public int getId_tmp() {
		return id_tmp;
	}
	
	public void setId_tmp(int id_tmp) {
		this.id_tmp = id_tmp;
	}
	
	public Competition getcompetition() {
		return competition;
	}
	
	public void setcompetition(Competition competition) {
		this.competition = competition;
	}
	
}
