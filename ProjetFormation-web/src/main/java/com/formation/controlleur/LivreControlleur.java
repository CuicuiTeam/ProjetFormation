package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.service.LivreService;

@Controller
public class LivreControlleur {

	@Autowired
	private LivreService livreService;

	@RequestMapping("/")
	private String accueil(Model model) {

		model.addAttribute("livres", livreService.getLivreRecommandes());
		return "accueil";
	}

	@RequestMapping("/periodiques")
	private String listePeriodiques(Model model) {

		model.addAttribute("listePeriodiques", livreService.getPeriodiques());
		return "periodiques";
	}

	// @RequestMapping("/bycategorie/{cat}")
	// private String listeByCategorie(@PathVariable String cat, Model model) {
	//
	//
	// model.addAttribute("livres", livreService.getLivreByCat(cat));
	//
	// }

}
