package com.lison.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Controller
@RequestMapping("/Accueil")
public class AccueilController {

	@Autowired
	private IMembreService membreService;

	@RequestMapping(method = RequestMethod.GET)
	public String afficherAccueil(final ModelMap pModel,
			@RequestParam(value = "personne") final String pPersonne) {

		List<Membre> membreList = membreService.findAll();

		pModel.addAttribute("personne", pPersonne);
		
		pModel.addAttribute("membreList", membreList);

		return "Accueil";
	}
}