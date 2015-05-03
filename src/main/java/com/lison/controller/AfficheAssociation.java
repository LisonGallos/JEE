
package com.lison.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lison.model.Association;
import com.lison.service.IServiceAssociation;

@Controller
@RequestMapping(value="/afficheAssociation")
public class AfficheAssociation {
	
	@Autowired
	private IServiceAssociation associationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) throws SQLException, ParseException {
		
		final List<Association> lListeAssociations = associationService.rechercherAssociations();
		pModel.addAttribute("listeAssociation", lListeAssociations);
		return "listeAssociation";
	}
}