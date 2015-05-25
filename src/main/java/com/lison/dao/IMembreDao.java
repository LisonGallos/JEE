
package com.lison.dao;

import com.lison.model.Membre;

public interface IMembreDao extends IAbstractDao<Membre> {
	
	void creerMembre(final Membre pMembre);
	
}