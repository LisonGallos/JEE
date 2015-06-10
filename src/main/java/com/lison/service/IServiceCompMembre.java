package com.lison.service;

import java.util.List;

import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Membre;

public interface IServiceCompMembre {

	List<CompMembre> findAll();

	CompMembre find(Object id);

	List<CompMembre> membresParComp(Competition competition);

	List<CompMembre> mbParCpExist(Competition competition, Membre membre);

	void creerCompMembre(CompMembre pCompMembre);
}