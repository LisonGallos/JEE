
package AssociationJEE.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import AssociationJEE.model.Association;
import AssociationJEE.services.IServiceAssociation;

@Controller
@RequestMapping(value="/afficheAssociation")
public class AfficheAssociation {
	
	@Autowired
	private IServiceAssociation service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) throws SQLException, ParseException {
		
		final List<Association> lListeAssociations = service.rechercherAssociations();
		pModel.addAttribute("listeAssociation", lListeAssociations);
		return "listeAssociation";
	}
}