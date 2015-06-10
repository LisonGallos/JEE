package com.lison.dao;

import java.util.List;

import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Membre;

public interface ICompMembreDao extends IAbstractDao<CompMembre> {

	void creerCompMembre(final CompMembre pCompMembre);

	List<CompMembre> membresParComp(Competition competition);

	List<CompMembre> mbParCpExist(Competition competition, Membre membre);
}