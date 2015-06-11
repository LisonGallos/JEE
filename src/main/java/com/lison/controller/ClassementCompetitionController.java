package com.lison.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/ClassementCompetition")
public class ClassementCompetitionController {

	@Autowired
	private ICompetitionService competitionService;

	@Autowired
	private IMembreService membreService;

	@Autowired
	private IServiceCompMembre compMembreService;

	@Autowired
	private IPerformanceService performanceService;

	private Competition competitionReturn = null;
	private String region = null;
	private Membre user = new Membre();

	private List<CompMembre> compMembreList = new ArrayList<CompMembre>();
	private final List<String> regionlist = new ArrayList<String>();

	/**
	 * @param pMembre
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheClassment(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		List<Competition> competitionList = competitionService.findAll();
		user = membreService.find(Integer.parseInt(pMembre));

		Map<Integer, Competition> competitionList2 = new HashMap<Integer, Competition>();
		for (Competition compet : competitionList) {
			competitionList2.put(compet.getID(), compet);
		}
		ModelAndView modelAndView = new ModelAndView("ClassementCompetition", Constants.Membre.COMMAND, user);
		modelAndView.addObject("compMembre", new CompMembre());
		modelAndView.addObject("competitionList", competitionList2);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView SelectClassmentCompetition(@ModelAttribute("compMembre") final CompMembre pCompMembre, final BindingResult result,
			final SessionStatus status) {

		ModelAndView modelAndView = new ModelAndView("ClassementCompetition", Constants.Membre.COMMAND, user);
		List<Performance> performanceList = new ArrayList<Performance>();
		List<CompMembre> cpList = new ArrayList<CompMembre>();

		if (pCompMembre.getId_tmp() != 1) {
			if (competitionReturn != null && region == null && !compMembreList.isEmpty()) {
				CompMembre cm = compMembreService.find(pCompMembre.getId_tmp());
				region = cm.getmembre().getAssociation().getRegion();
				performanceList = performanceService.membreRegionPerfCp(cm, competitionReturn);

				modelAndView.addObject("Laregion", region);
				modelAndView.addObject("competitionReturn", competitionReturn);
				modelAndView.addObject("performanceList", performanceList);
			}

			if (competitionReturn == null && region == null) {

				if (pCompMembre.getId_tmp() != 1)
					competitionReturn = competitionService.find(pCompMembre.getId_tmp());
				modelAndView.addObject(competitionReturn);

				if (competitionReturn != null && region == null) {
					compMembreList = compMembreService.membresParComp(competitionReturn);
					performanceList = performanceService.membrePerfCp(competitionReturn);
					if (compMembreList != null && performanceList != null) {
						for (CompMembre cp : compMembreList) {
							for (Performance pf : performanceList) {
								if (cp.getmembre().getID() == pf.getMembre().getID()) {
									if (!regionlist.contains(cp.getmembre().getAssociation().getRegion())) {
										regionlist.add(cp.getmembre().getAssociation().getRegion());
										cpList.add(cp);
									}
								}
							}
						}
					}
				}
				modelAndView.addObject("regionlist", cpList);
			} else {

				if (!regionlist.isEmpty()) {
					competitionReturn = null;
					region = null;
					regionlist.clear();
					compMembreList.clear();
				}
			}
		}
		modelAndView.addObject("compMembre", new CompMembre());
		return modelAndView;
	}
}