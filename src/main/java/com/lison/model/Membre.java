package com.lison.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBRE")
public class Membre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String nom;

	@Column(name = "LAST_NAME")
	private String prenom;

	@Column(name = "MAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "VALIDATED")
	private Integer compte_valide;

	@Column(name = "ROLE")
	private String responsabilite;

	@Column(name = "CREATION_DATE")
	private Date date_inscription;

	@Column(name = "BIRTH_DATE")
	private Date date_naissance;

	public int getID() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCompte_valide() {
		return compte_valide;
	}

	public void setCompte_valide(Integer compte_valide) {
		this.compte_valide = compte_valide;
	}

	public String getResponsabilite() {
		return responsabilite;
	}

	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
}
