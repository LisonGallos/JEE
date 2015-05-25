package com.lison.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lison.model.Membre;
import com.lison.service.IMembreService;

@Controller
@RequestMapping("/Accueil")
public class AccueilController {

	@Autowired
	private IMembreService membreService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView afficherAccueil(@RequestParam(value = "membre") final String pMembre) {

	//	List<Membre> membreList = membreService.findAll();

		ModelAndView modelAndView = new ModelAndView("Accueil");
		modelAndView.addObject("personne", pMembre);
		modelAndView.addObject("membre", new Membre());
		
	//	pModel.addAttribute("membreList", membreList);

		/*<c:forEach var="membre" items="${membreList}">
	    	<option value="10"><c:out value="${membre.nom}" /></option>
		</c:forEach>*/

		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enregistrerMembre(@ModelAttribute("membre") Membre membre,
			BindingResult result, SessionStatus status) {
		
		ModelAndView modelAndView = new ModelAndView("Accueil");
//		membreService.creerMembre(membre.getNom(), membre.getPrenom(), "", Calendar.getInstance().getTime());

		return modelAndView;
	}
	
	@RequestMapping(value = "/listMembre", method = RequestMethod.GET)
	public ModelAndView listerMembre() {
		
		ModelAndView modelAndView = new ModelAndView("Accueil");
		List<Membre> membreList = membreService.findAll();
		
		modelAndView.addObject("membre", new Membre());
		modelAndView.addObject("membreList", membreList);

		return modelAndView;
	}
	
	
}