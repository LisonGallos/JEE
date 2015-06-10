package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.impl.CompMembreDaoImpl;
import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Membre;
import com.lison.service.IServiceCompMembre;

@Service("compMembreService")
public class CompMembreServiceImpl implements IServiceCompMembre {

	@Autowired
	private CompMembreDaoImpl compMembreDao;

	public List<CompMembre> findAll() {
		return compMembreDao.findAll();
	}

	public CompMembre find(final Object id) {
		return compMembreDao.find(id);
	}

	public List<CompMembre> membresParComp(final Competition competition) {
		return compMembreDao.membresParComp(competition);
	}

	public List<CompMembre> mbParCpExist(final Competition competition, final Membre membre) {
		return compMembreDao.mbParCpExist(competition, membre);
	}

	public void creerCompMembre(final CompMembre pCompMembre) {
		compMembreDao.creerCompMembre(pCompMembre);
	}
}