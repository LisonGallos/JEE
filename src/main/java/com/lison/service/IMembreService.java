package com.lison.service;

import java.util.List;

import com.lison.model.Association;
import com.lison.model.Competition;
import com.lison.model.Membre;

public interface IMembreService {

	void persist(Membre membre);

	List<Membre> findAll();

	void creerMembre(Membre pMembre);

	Membre find(Object id);

	List<Membre> membreNonValide();

	void remove(Object entityId);

	List<Membre> listeMembreValideDesc(Membre Membre);

	List<Membre> login(String nom, String password);

	List<Membre> membreParRegionCp(Competition competition, Association association);

	List<Membre> membreParAsso(Association association);

	List<Membre> referentAsso(Membre membre);

}
