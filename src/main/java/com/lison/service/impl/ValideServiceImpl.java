package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.impl.ValideDaoImpl;
import com.lison.model.Valide;
import com.lison.service.IServiceValide;

@Service("valideService")
public class ValideServiceImpl implements IServiceValide {
	
	@Autowired
	private ValideDaoImpl valideDao;	

	public List<Valide> findAll() {
		return valideDao.findAll();
	}

	public Valide find(Object id) {
		return valideDao.find(id);
	}
}