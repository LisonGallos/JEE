package com.lison.dao;

import java.util.List;

import com.lison.model.Association;
import com.lison.model.Competition;
import com.lison.model.Membre;

public interface IMembreDao extends IAbstractDao<Membre> {

	void creerMembre(final Membre pMembre);

	public List<Membre> listeMembreValideDesc(Membre Membre);

	List<Membre> login(String nom, String password);

	List<Membre> membreParRegionCp(Competition competition, Association association);

	List<Membre> membreParAsso(Association association);

	List<Membre> referentAsso(Membre membre);

}