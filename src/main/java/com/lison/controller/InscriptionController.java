package com.lison.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lison.constants.Constants;
import com.lison.model.Association;
import com.lison.model.Membre;
import com.lison.service.IMembreService;
import com.lison.service.IServiceAssociation;
import com.lison.service.IServiceRole;
import com.lison.service.IServiceValide;

@Controller
@RequestMapping("/Inscription")
public class InscriptionController {

	@Autowired
	private IMembreService membreService;

	@Autowired
	private IServiceAssociation associationService;

	@Autowired
	private IServiceValide valideService;

	@Autowired
	private IServiceRole roleService;

	private final SecureRandom random = new SecureRandom();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheInscription() {

		ModelAndView modelAndView = new ModelAndView(Constants.Membre.INSCRIPTION);
		modelAndView.addObject(Constants.Membre.MEMBRE, new Membre());
		modelAndView.addObject("association", new Association());
		modelAndView.addObject("associationList", getAssociationList());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enregistrerMembre(@ModelAttribute(Constants.Membre.MEMBRE) final Membre pMembre, final BindingResult result, final SessionStatus status) {

		ModelAndView modelAndView = new ModelAndView("InscriptionOK");

		if (pMembre.getNom() == null || "".equals(pMembre.getNom())) {
			result.reject("nom", "Le mendre doit avoir un nom");
			modelAndView = new ModelAndView(Constants.Membre.INSCRIPTION);
			modelAndView.addObject("associationList", getAssociationList());
		} else {
			if (pMembre.getPrenom() == null || "".equals(pMembre.getPrenom())) {
				result.reject("prenom", "Le mendre doit avoir un prenom");
				modelAndView = new ModelAndView(Constants.Membre.INSCRIPTION);
				modelAndView.addObject("associationList", getAssociationList());
			} else {
				if (pMembre.getEmail() == null || "".equals(pMembre.getEmail())) {
					result.reject("email", "Le mendre doit avoir un Email");
					modelAndView = new ModelAndView(Constants.Membre.INSCRIPTION);
					modelAndView.addObject("associationList", getAssociationList());
				} else {
					if (pMembre.getDate_naissance_string() == null || "".equals(pMembre.getDate_naissance_string())) {
						result.reject("date_naissance_string", "La date de naissance n'est pas valide");
						modelAndView = new ModelAndView(Constants.Membre.INSCRIPTION);
						modelAndView.addObject("associationList", getAssociationList());
					} else {
						Association asso = associationService.find(pMembre.getId_tmp());
						pMembre.setAssociation(asso);
						pMembre.setCompte_valide(valideService.find(1));
						pMembre.setResponsabilite(roleService.find(2));
						pMembre.setDate_inscription(new java.util.Date());
						pMembre.setPassword(nextSessionId());
						membreService.creerMembre(pMembre);
					}
				}
			}
		}

		return modelAndView;
	}

	public String nextSessionId() {

		String Big = new BigInteger(130, random).toString(32);
		String s = Big.substring(0, 8);

		return s;
	}

	private List<Association> getAssociationList() {
		List<Association> associationList = associationService.findAll();

		Map<Integer, Association> associationList2 = new HashMap<Integer, Association>();
		for (Association asso : associationList) {
			associationList2.put(asso.getID(), asso);
		}
		return associationList;
	}
}
