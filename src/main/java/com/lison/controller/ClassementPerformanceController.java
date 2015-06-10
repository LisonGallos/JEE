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
import com.lison.model.Performance;
import com.lison.service.IMembreService;
import com.lison.service.IPerformanceService;

@Controller
@RequestMapping("/ClassementPerformance")
public class ClassementPerformanceController {

	@Autowired
	private IPerformanceService performanceService;

	@Autowired
	private IMembreService membreService;

	private Membre user = new Membre();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheClassmentPerformance(@RequestParam(value = Constants.Membre.MEMBRE) final String pMembre) {

		user = membreService.find(Integer.parseInt(pMembre));
		Performance performanceTmp;

		final List<Performance> meilleurePerf = new ArrayList<Performance>();
		final List<String> regionlist = new ArrayList<String>();
		final List<Performance> performanceList = performanceService.membrePerfDesc();
		final List<Membre> membreList = membreService.findAll();

		for (Membre membre : membreList) {
			performanceTmp = null;
			for (Performance pf : performanceList) {
				if (pf.getMembre().getID() == membre.getID()) {
					if (performanceTmp == null)
						performanceTmp = pf;
					else if (performanceTmp.getPoints() < pf.getPoints()) {
						performanceTmp = performanceService.find(pf.getID());
					}
				}
			}
			if (performanceTmp != null) {
				meilleurePerf.add(performanceTmp);
				if (!regionlist.contains(membreService.find(performanceTmp.getMembre().getID()).getAssociation().getRegion()))
					regionlist.add(membre.getAssociation().getRegion());

			}
		}

		ModelAndView modelAndView = new ModelAndView("ClassementPerformance", Constants.Membre.COMMAND, user);
		modelAndView.addObject("meilleurePerf", meilleurePerf);
		modelAndView.addObject("regionlist", regionlist);

		return modelAndView;
	}
}