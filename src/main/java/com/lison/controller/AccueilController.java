package com.lison.controller;

import java.net.BindException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lison.constants.Constants;
import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Controller
@RequestMapping("/Accueil")
public class AccueilController {

	@Autowired
	private IMembreService membreService;

	Membre user = new Membre();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView afficherAccueil(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre, final HttpServletRequest request,
			final Object command, final BindException errors) {

		user = membreService.find(Integer.parseInt(pMembre));

		ModelAndView modelAndView = new ModelAndView("Accueil", Constants.Membre.COMMAND, user);
		modelAndView.addObject(Constants.Membre.MEMBRE, user);

		return modelAndView;
	}

}