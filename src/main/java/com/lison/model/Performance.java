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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.lison.utils.DateUtils;

@Entity
@Table(name = "PERFORMANCE")
public class Performance {

	@Id
	@Autowired(required = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int ID;

	@Column(name = "NAME")
	private String intitule;

	@Column(name = "POINT")
	private int points;

	@Column(name = "PERF_DT")
	private Date date_performance;

	@Transient
	private String date_performance_string;

	@Column(name = "IDTMP")
	private int id_tmp;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MBR")
	private Membre membre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COMP")
	private Competition competition = new Competition();

	public int getID() {
		return ID;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(final String intitule) {
		this.intitule = intitule;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(final int points) {
		this.points = points;
	}

	public Date getDate_performance() {
		return date_performance;
	}

	public void setDate_performance(final Date date_performance) {
		this.date_performance = date_performance;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(final Membre membre) {
		this.membre = membre;
	}

	public void setCompetition(final Competition competition) {
		this.competition = competition;
	}

	public Competition getCompetition() {
		return competition;
	}

	public int getId_tmp() {
		return id_tmp;
	}

	public void setId_tmp(final int id_tmp) {
		this.id_tmp = id_tmp;
	}

	public String getDate_performance_string() {
		return date_performance_string;
	}

	public void setDate_performance_string(final String date_performance_string) {
		this.date_performance_string = date_performance_string;
	}

	@PrePersist
	public void onPersist() {
		this.date_performance = DateUtils.parseToDate(this.date_performance_string, DateUtils.DATE_DD_MM_YYYY_PATTERN);
	}

	@PreUpdate
	public void onUpdate() {
		this.date_performance = DateUtils.parseToDate(this.date_performance_string, DateUtils.DATE_DD_MM_YYYY_PATTERN);
	}
}
