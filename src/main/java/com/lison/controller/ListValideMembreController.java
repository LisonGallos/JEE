package com.lison.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lison.constants.Constants;
import com.lison.model.Membre;
import com.lison.model.Valide;
import com.lison.service.IMembreService;
import com.lison.service.IServiceValide;

@Controller
@RequestMapping("/ListValideMembre")
public class ListValideMembreController {

	@Autowired
	private IMembreService membreService;

	@Autowired
	private IServiceValide valideService;

	private List<Membre> listeMembreValideDesc = new ArrayList<Membre>();
	private Membre user = new Membre();
	private List<Valide> listValide = new ArrayList<Valide>();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheInscription(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		user = membreService.find(Integer.parseInt(pMembre));
		listValide = valideService.findAll();
		listeMembreValideDesc = membreService.listeMembreValideDesc(user);

		ModelAndView modelAndView = new ModelAndView("ListValideMembre", Constants.Membre.COMMAND, user);
		modelAndView.addObject(Constants.Membre.MEMBRE, new Membre());
		modelAndView.addObject("membreList", listeMembreValideDesc);
		modelAndView.addObject("valideList", listValide);

		return modelAndView;
	}
}
