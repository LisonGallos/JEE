package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.IMembreDao;
import com.lison.dao.IRoleDao;
import com.lison.model.Association;
import com.lison.model.Competition;
import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Service("membreService")
public class MembreServiceImpl implements IMembreService {

	@Autowired
	private IMembreDao membreDao;

	@Autowired
	private IRoleDao roleDao;

	Membre mmbre = new Membre();

	public void persist(final Membre membre) {
		membreDao.persist(membre);
	}

	public List<Membre> findAll() {
		return membreDao.findAll();
	}

	public void creerMembre(final Membre pMembre) {
		membreDao.creerMembre(pMembre);
	}

	public Membre find(final Object id) {
		return membreDao.find(id);
	}

	public List<Membre> membreNonValide() {
		List<Membre> membreList = membreDao.findAll();

		for (Membre membre : membreList) {
			if (membre.getCompte_valide().getID() == 2) {
				membreList.remove(membre.getID());
			}
		}
		return membreList;
	}

	public void remove(final Object entityId) {
		membreDao.remove(entityId);

	}

	public List<Membre> listeMembreValideDesc(final Membre Membre) {
		return membreDao.listeMembreValideDesc(Membre);
	}

	public List<Membre> login(final String nom, final String password) {
		return membreDao.login(nom, password);
	}

	public List<Membre> membreParRegionCp(final Competition competition, final Association association) {
		return membreDao.membreParRegionCp(competition, association);
	}

	public List<Membre> membreParAsso(final Association association) {
		return membreDao.membreParAsso(association);
	}

}
