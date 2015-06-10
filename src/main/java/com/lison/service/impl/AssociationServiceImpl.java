package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.impl.AssociationDaoImpl;
import com.lison.model.Association;
import com.lison.service.IServiceAssociation;

@Service("associationService")
public class AssociationServiceImpl implements IServiceAssociation {
	
	@Autowired
	private AssociationDaoImpl associationDao;	

	public List<Association> findAll(){
		return associationDao.findAll();
	}

	public Association find(Object id){
		return associationDao.find(id);
	}
}