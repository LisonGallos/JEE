package com.lison.service;

import java.util.Date;
import java.util.List;

import com.lison.model.Association;
import com.lison.model.Membre;

public interface IMembreService {
	
	List<Membre> findAll();
	
	void creerMembre(String nom, String prenom, String email, int responsabilite,
			Date date_inscription, Date date_naissance);
}
