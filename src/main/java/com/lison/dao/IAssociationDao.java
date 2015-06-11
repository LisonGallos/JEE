package com.lison.dao;

import com.lison.model.Association;

public interface IAssociationDao extends IAbstractDao<Association> {

	void creerAssociation(final Association pAssociation);

}