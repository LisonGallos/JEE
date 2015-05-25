
package com.lison.dao.impl;

import com.lison.dao.IAbstractDao;
import com.lison.model.Membre;

public interface IMembreDao extends IAbstractDao<Membre> {
	
	boolean creerMembre(final Membre pMembre);
	
}