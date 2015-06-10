package com.lison.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.lison.model.Membre;
import com.lison.model.Valide;
import com.lison.service.IMembreService;
import com.lison.service.IServiceAssociation;
import com.lison.service.IServiceValide;

@Controller
@RequestMapping("/ValideMembre")
public class ValideMembreController {

	@Autowired
	private IMembreService membreService;

	@Autowired
	private IServiceAssociation associationService;

	@Autowired
	private IServiceValide valideService;

	private Valide valide = new Valide();
	private List<Valide> listValide = new ArrayList<Valide>();
	private Membre user = new Membre();
	private Membre membreCourant = new Membre();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView ValideMembre(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		String[] parts = pMembre.split(":");
		String part1 = parts[0];
		String part2 = parts[1];
		user = membreService.find(Integer.parseInt(part1));
		membreCourant = membreService.find(Integer.parseInt(part2));

		listValide = valideService.findAll();
		ModelAndView modelAndView = new ModelAndView("ValideMembre", Constants.Membre.COMMAND, user);
		modelAndView.addObject(Constants.Membre.MEMBRE, membreCourant);
		modelAndView.addObject("valideList", listValide);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView AvalideMembre(@ModelAttribute(Constants.Membre.MEMBRE) final Membre pMembre, final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {

		valide = valideService.find(pMembre.getId_tmp());
		if (membreCourant.getCompte_valide().getID() != valide.getID()) {
			membreCourant.setCompte_valide(valide);
			membreCourant.setMessage(pMembre.getMessage());
			membreService.persist(membreCourant);
			// JavaMailController java = new JavaMailController();
			// java.sendEmail(membreCourant);
		}
		ModelAndView modelAndView = new ModelAndView("ListValideMembre", Constants.Membre.COMMAND, user);

		return modelAndView;
	}

}