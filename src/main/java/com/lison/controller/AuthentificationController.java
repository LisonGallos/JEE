package com.lison.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lison.constants.Constants;
import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Controller
@RequestMapping("/Authentification")
public class AuthentificationController {

	@Autowired
	private IMembreService membreService;

	private Membre user = new Membre();

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheInscription() {

		ModelAndView modelAndView = new ModelAndView(Constants.Membre.AUTHENTIFICATION);
		modelAndView.addObject(Constants.Membre.MEMBRE, new Membre());

		return modelAndView;
	}

	/**
	 * @param pMembre
	 * @param result
	 * @param status
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enregistrerMembre(@ModelAttribute(Constants.Membre.MEMBRE) final Membre pMembre, final BindingResult result, final SessionStatus status) {

		ModelAndView modelAndView;
		List<Membre> membrelist = membreService.login(pMembre.getNom(), pMembre.getPassword());
		if (pMembre.getNom() == null || "".equals(pMembre.getNom())) {
			result.reject("nom", "Il faut renseigner un Nom");
			modelAndView = new ModelAndView(Constants.Membre.AUTHENTIFICATION);
		} else {
			if (pMembre.getPassword() == null || "".equals(pMembre.getPassword())) {
				result.reject("nom", "Il faut renseginer un mot de passe");
				modelAndView = new ModelAndView(Constants.Membre.AUTHENTIFICATION);
			} else {
				if (membrelist.size() == 1) {
					user = membreService.find(membrelist.get(0).getID());
					modelAndView = new ModelAndView("Accueil", Constants.Membre.COMMAND, user);
				} else {
					modelAndView = new ModelAndView("Authentification");
				}
			}
		}
		return modelAndView;
	}

}
