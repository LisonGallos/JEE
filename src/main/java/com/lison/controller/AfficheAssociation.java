
package com.lison.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lison.model.Association;
import com.lison.model.Competition;
import com.lison.model.Performance;
import com.lison.service.IPerformanceService;
import com.lison.service.IServiceAssociation;
import com.lison.service.ICompetitionService; 

@Controller
@RequestMapping(value="/afficheAssociation")
public class AfficheAssociation extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired(required=true)
	private IServiceAssociation associationService;
	
	@Autowired
	private ICompetitionService competitionService;
	
	@Autowired
	private IPerformanceService performanceService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) throws SQLException, ParseException {
		
		final List<Association> lListeAssociations = associationService.findAll();
		pModel.addAttribute("listeAssociation", lListeAssociations);
		
		final List<Competition> lListecompetitions = competitionService.findAll();
		pModel.addAttribute("lListecompetition", lListecompetitions);
		
		final List<Performance> lListePerformances = performanceService.findAll();
		pModel.addAttribute("lListePerformance", lListePerformances);		
		
		
		return "listeAssociation"+"lListePerformance"+"lListecompetition" ;
	}
}