package com.lison.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.IMembreDao;
import com.lison.model.Association;
import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Service("membreService")
public class MembreServiceImpl implements IMembreService {

	@Autowired
	private IMembreDao membreDao;	

	Membre mmbre = new Membre();
	
	public List<Membre> findAll() {
		return membreDao.findAll();
	}
	
	public void creerMembre(String nom, String prenom, String email,
			int responsabilite,  Date date_inscription, Date date_naissance) {

		Membre membre = new Membre();
		
		membre.setNom(nom);
		membre.setPrenom(prenom);
		membre.setEmail(email);
		membre.setPassword("pass");
		membre.setCompte_valide(0);
		membre.setResponsabilite(responsabilite);
		membre.setDate_inscription(date_inscription);
		membre.setDate_naissance(date_naissance);
		
		membreDao.persist(membre);
		
	}
	
	public Membre findMembre(int ID){
		
		mmbre = membreDao.find(ID);		
		return mmbre;		
	}

}
