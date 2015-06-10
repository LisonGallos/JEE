package com.lison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Index")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView afficherAccueil() {

		ModelAndView modelAndView = new ModelAndView("Index");
		return modelAndView;
	}

}