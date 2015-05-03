package com.lison.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lison.dao.impl.AssociationDaoImpl;
import com.lison.model.Association;
import com.lison.service.IServiceAssociation;

@Service("associationService")
public class AssociationServiceImpl implements IServiceAssociation {
	
	@Autowired
	private AssociationDaoImpl associationDao;
	
//	@Transactional(readOnly=true)
	public List<Association> rechercherAssociations() throws SQLException, ParseException {
		return associationDao.findAll();
	}
}