package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.dao.IValideDao;
import com.lison.model.Valide;

@Repository("valideDao")
public class ValideDaoImpl extends AbstractDao<Valide> implements IValideDao {

	public ValideDaoImpl() {
		super(Valide.class);
	}
}
