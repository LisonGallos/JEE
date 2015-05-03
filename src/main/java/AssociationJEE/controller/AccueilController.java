package AssociationJEE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Accueil")
public class AccueilController {

    @RequestMapping(method = RequestMethod.GET)
    public String afficherAccueil(final ModelMap pModel, 
            @RequestParam(value="personne") final String pPersonne) {
    	
        pModel.addAttribute("personne", pPersonne);
        return "Accueil";
    }
}