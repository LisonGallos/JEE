package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.dao.IAssociationDao;
import com.lison.model.Association;

@Repository("associationDao")
public class AssociationDaoImpl extends AbstractDao<Association> implements IAssociationDao {

	public AssociationDaoImpl() {
		super(Association.class);
	}

}
