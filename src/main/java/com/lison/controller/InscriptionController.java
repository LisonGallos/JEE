package com.lison.controller;

import java.util.Calendar;
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

import com.lison.dao.IAssociationDao;
import com.lison.model.Association;
import com.lison.model.Membre;
import com.lison.service.IMembreService;
import com.lison.service.IServiceAssociation;
import com.lison.service.impl.AssociationServiceImpl;

@Controller
@RequestMapping("/Inscription")
public class InscriptionController {

	@Autowired
	private IMembreService membreService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AfficheInscription(@RequestParam(value = "membre") final String pMembre) {
		
		ModelAndView modelAndView = new ModelAndView("Inscription");
		modelAndView.addObject("personne", pMembre);
		modelAndView.addObject("membre", new Membre());		
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enregistrerMembre(@ModelAttribute("membre") Membre membre,
			BindingResult result, SessionStatus status) {
		
						
		ModelAndView modelAndView = new ModelAndView("InscriptionOK");
		membreService.creerMembre(membre.getNom(), membre.getPrenom(), membre.getEmail(),
				membre.getResponsabilite(), 
				Calendar.getInstance().getTime(), membre.getDate_naissance());

		return modelAndView;
	}
}

/*
<form:form method="post" modelAttribute="creationMembre" action="creerMembre">
<p>Nom</p>
<b><i><form:errors path="nom" cssclass="error"/></i></b><br>
<p>Prenom</p>
<b><i><form:errors path="prenom" cssclass="error"/></i></b><br>
<p>Email</p>
<b><i><form:errors path="email" cssclass="error"/></i></b><br>
<p>Date de naissance</p>
<b><i><form:errors path="date_naissance" cssclass="error"/></i></b><br>
<input type="submit"/>
</form:form>

*        
 				
                <c:forEach items="${membreInscrit}" var="membre">
                    <tr>
                        <td><c:out value="${membre.id}"/></td>
                        <td><c:out value="${membre.nom}"/></td>
                        <td><c:out value="${membre.prenom}"/></td>
                        <td><c:out value="${membre.email}"/></td>
                        <td><c:out value="${membre.password}"/></td>
                        <td><c:out value="${membre.compte_valide}"/></td>
                        <td><c:out value="${membre.responsabilite}"/></td>
                        <td><c:out value="${membre.date_inscription}"/></td>
                        <td><c:out value="${membre.date_naissance}"/></td>
                    </tr>
                </c:forEach>

<html>
    <head>
        <title>Liste membre</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Valide</th>
                    <th>Responsabilité</th>
                    <th>Inscription</th>
                    <th>Date de naissance</th>
                </tr>
            </thead>
            <tbody>
            
				<c:if test="${not empty lists}">
				<tr>
	                <c:forEach var="listValue" items="${lists}">
						<td>${listValue}</td>
					</c:forEach>
				</tr>
 				</c:if>
                
            </tbody>
        </table>
    </body>
</html>*/