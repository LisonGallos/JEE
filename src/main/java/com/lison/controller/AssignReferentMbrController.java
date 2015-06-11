package com.lison.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lison.constants.Constants;
import com.lison.model.Membre;
import com.lison.model.Role;
import com.lison.service.IMembreService;
import com.lison.service.IServiceRole;

@Controller
@RequestMapping("/AssigneReferentMbr")
public class AssignReferentMbrController {

	@Autowired
	private IMembreService membreService;

	@Autowired
	private IServiceRole roleService;

	private Membre user = new Membre();
	private Membre membreCourant = new Membre();
	private List<Role> roleList = new ArrayList<Role>();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheInscription(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		String[] parts = pMembre.split(":");
		String part1 = parts[0];
		String part2 = parts[1];
		user = membreService.find(Integer.parseInt(part1));
		membreCourant = membreService.find(Integer.parseInt(part2));

		roleList = roleService.findAll();

		ModelAndView modelAndView = new ModelAndView("AssigneReferentMbr", Constants.Membre.COMMAND, user);
		modelAndView.addObject(Constants.Membre.MEMBRE, membreCourant);
		modelAndView.addObject("roleList", roleList);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView AvalideMembre(@ModelAttribute(Constants.Membre.MEMBRE) final Membre pMembre) {

		Role role = roleService.find(pMembre.getId_tmp());
		List<Membre> membreList = membreService.referentAsso(membreCourant);
		ModelAndView modelAndView = new ModelAndView("AssigneReferent", Constants.Membre.COMMAND, user);

		if (membreCourant.getResponsabilite().getID() != role.getID()) {
			if (membreList != null) {

				if (membreCourant.getResponsabilite().getID() == 3) {
					membreCourant.setResponsabilite(role);
					membreService.persist(membreCourant);
				} else {
					System.out.println("Un référent est déjà présent pour cette association");
					modelAndView = new ModelAndView("AssigneReferentKO", Constants.Membre.COMMAND, user);

				}
			} else {
				membreCourant.setResponsabilite(role);
				membreService.persist(membreCourant);
			}
		}
		return modelAndView;
	}
}
