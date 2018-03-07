package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.service.AuteurService;

@Controller
public class AuteurControlleur {
	@Autowired
	private AuteurService auteurService;
	
	@RequestMapping("/auteurs")
	private String auteurs (Model model) {
		model.addAttribute("auteurs", auteurService.getAll());
		model.addAttribute("titre", "Auteurs");
		return "auteurs";
}
}
