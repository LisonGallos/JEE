package com.lison.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lison.constants.Constants;
import com.lison.model.Association;
import com.lison.model.Membre;
import com.lison.service.IMembreService;
import com.lison.service.IServiceAssociation;

@Controller
@RequestMapping("/AssigneReferent")
public class AssigneReferentController {

	@Autowired
	private IMembreService membreService;

	@Autowired
	private IServiceAssociation associationService;

	private Membre user = new Membre();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheInscription(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		user = membreService.find(Integer.parseInt(pMembre));

		List<Association> associationList = new ArrayList<Association>();
		if (user.getResponsabilite().getID() == 4) {
			associationList = associationService.findAll();
		}
		Map<Integer, Association> associationList2 = new HashMap<Integer, Association>();
		for (Association asso : associationList) {
			associationList2.put(asso.getID(), asso);
		}

		ModelAndView modelAndView = new ModelAndView("AssigneReferent", "command", user);
		modelAndView.addObject(Constants.Membre.MEMBRE, new Membre());
		modelAndView.addObject("associationList", associationList2);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView AvalideMembre(@ModelAttribute(Constants.Membre.MEMBRE) final Membre pMembre, final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		List<Membre> membreList = new ArrayList<Membre>();

		Association association = associationService.find(pMembre.getId_tmp());
		membreList = membreService.membreParAsso(association);

		ModelAndView modelAndView = new ModelAndView("AssigneReferent", Constants.Membre.COMMAND, user);
		modelAndView.addObject(Constants.Membre.MEMBRELIST, membreList);

		return modelAndView;
	}

}
