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

import com.lison.constants.Constants;
import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Membre;
import com.lison.model.Performance;
import com.lison.service.ICompetitionService;
import com.lison.service.IMembreService;
import com.lison.service.IPerformanceService;
import com.lison.service.IServiceCompMembre;

@Controller
@RequestMapping("/CreerPerformance")
public class CreerPerformanceController {

	@Autowired
	private IPerformanceService performanceService;

	@Autowired
	private ICompetitionService competitionService;

	@Autowired
	private IServiceCompMembre compMembreService;

	@Autowired
	private IMembreService membreService;

	private Membre user;
	private Competition competition = new Competition();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheCreerPerformance(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		user = membreService.find(Integer.parseInt(pMembre));

		ModelAndView modelAndView = new ModelAndView(Constants.Membre.CREERPERFORMANCE, Constants.Membre.COMMAND, user);
		modelAndView.addObject("performance", new Performance());

		modelAndView.addObject("competition", new Competition());
		modelAndView.addObject("competitionList", getCompetitionList());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enregistrerPerformance(@ModelAttribute("performance") final Performance pPerformance, final BindingResult result,
			final SessionStatus status) {

		ModelAndView modelAndView = new ModelAndView("PerformanceOK", Constants.Membre.COMMAND, user);
		CompMembre cp = new CompMembre();

		if (pPerformance.getIntitule() == null || "".equals(pPerformance.getIntitule())) {
			result.reject("intitule", "L'intitule ne doit pâs être vide");
			modelAndView = new ModelAndView(Constants.Membre.CREERPERFORMANCE, Constants.Membre.COMMAND, user);
			modelAndView.addObject("competitionList", getCompetitionList());
		} else {
			if (pPerformance.getPoints() == 0 || "".equals(pPerformance.getPoints())) {
				result.reject("points", "La performance doit comprendre des points");
				modelAndView = new ModelAndView(Constants.Membre.CREERPERFORMANCE, Constants.Membre.COMMAND, user);
				modelAndView.addObject("competitionList", getCompetitionList());
			} else {
				if (pPerformance.getDate_performance_string() == null || "".equals(pPerformance.getDate_performance_string())) {
					result.reject("intitule", "La performance doit avoir une date");
					modelAndView = new ModelAndView(Constants.Membre.CREERPERFORMANCE, Constants.Membre.COMMAND, user);
					modelAndView.addObject("competitionList", getCompetitionList());
				} else {
					pPerformance.setIntitule(pPerformance.getIntitule());
					pPerformance.setMembre(user);
					pPerformance.setPoints(pPerformance.getPoints());
					pPerformance.setDate_performance(pPerformance.getDate_performance());
					if (pPerformance.getId_tmp() != 1) {
						pPerformance.setCompetition(competitionService.find(pPerformance.getId_tmp()));
						competition = competitionService.find(pPerformance.getId_tmp());
						if (compMembreService.mbParCpExist(competition, user) == null) {

							cp.setcompetition(competition);
							cp.setmembre(user);
							compMembreService.creerCompMembre(cp);
						}

					} else {
						if (pPerformance.getCompetition().getNom() == null || "".equals(pPerformance.getCompetition().getNom())) {
							result.reject("intitule", "L'intitule ne doit pas être vide");
							modelAndView = new ModelAndView(Constants.Membre.CREERPERFORMANCE, Constants.Membre.COMMAND, user);
						} else {
							if (pPerformance.getCompetition().getPoints() == 0 || "".equals(pPerformance.getCompetition().getPoints())) {
								result.reject("points", "La compétition doit comprendre des points");
								modelAndView = new ModelAndView(Constants.Membre.CREERPERFORMANCE, Constants.Membre.COMMAND, user);
							} else {
								competitionService.creerCompetition(pPerformance.getCompetition());
								List<Competition> competitionList = competitionService.findAll();
								competition = competitionService.find(competitionList.size());
								cp.setcompetition(competition);
								cp.setmembre(user);
								compMembreService.creerCompMembre(cp);
							}
							if (pPerformance.getCompetition() != null)
								performanceService.creerPerformance(pPerformance);
						}
					}
				}
			}
		}
		return modelAndView;
	}

	private List<Competition> getCompetitionList() {

		List<Competition> competitionList = competitionService.findAll();
		return competitionList;
	}

}