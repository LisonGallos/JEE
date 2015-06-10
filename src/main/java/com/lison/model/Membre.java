package com.lison.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.lison.utils.DateUtils;

@Entity
@Table(name = "MEMBRE")
public class Membre {

	@Id
	@Autowired(required = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int ID;

	@Column(name = "NAME")
	private String nom;

	@Column(name = "LAST_NAME")
	private String prenom;

	@Column(name = "MAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_VALIDE")
	private Valide compte_valide;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ROLE")
	private Role responsabilite;

	@Column(name = "CREATION_DATE")
	private Date date_inscription;

	@Column(name = "BIRTH_DATE")
	private Date date_naissance;

	@Transient
	private String date_naissance_string;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ASSO")
	private Association association;

	@Column(name = "IDTMP")
	private int id_tmp = 0;

	@Column(name = "MESSAGE")
	private String message;

	public int getID() {
		return ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Valide getCompte_valide() {
		return compte_valide;
	}

	public void setCompte_valide(final Valide compte_valide) {
		this.compte_valide = compte_valide;
	}

	public Role getResponsabilite() {
		return responsabilite;
	}

	public void setResponsabilite(final Role responsabilite) {
		this.responsabilite = responsabilite;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(final Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(final Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(final Association association) {
		this.association = association;
	}

	public int getId_tmp() {
		return id_tmp;
	}

	public void setId_tmp(final int id_tmp) {
		this.id_tmp = id_tmp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getDate_naissance_string() {
		return date_naissance_string;
	}

	public void setDate_naissance_string(final String date_naissance_string) {
		this.date_naissance_string = date_naissance_string;
	}

	@PrePersist
	public void onPersist() {
		this.date_naissance = DateUtils.parseToDate(this.date_naissance_string, DateUtils.DATE_DD_MM_YYYY_PATTERN);
	}

	// @PreUpdate
	// public void onUpdate() {
	// this.date_naissance = DateUtils.parseToDate(this.date_naissance_string, DateUtils.DATE_DD_MM_YYYY_PATTERN);
	// }

}
