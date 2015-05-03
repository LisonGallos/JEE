package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.IMembreDao;
import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Service("membreService")
public class MembreServiceImpl implements IMembreService {

	@Autowired
	private IMembreDao membreDao;
	
	public List<Membre> findAll() {
		return membreDao.findAll();
	}

}
