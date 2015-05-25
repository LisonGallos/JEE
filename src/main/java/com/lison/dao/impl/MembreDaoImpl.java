package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.dao.IMembreDao;
import com.lison.model.Membre;

@Repository("membreDao")
public class MembreDaoImpl extends AbstractDao<Membre> implements IMembreDao {

	public MembreDaoImpl() {
		super(Membre.class);
	}

	public void creerMembre(Membre pMembre) {
		this.persist(pMembre);
	}
	
}
