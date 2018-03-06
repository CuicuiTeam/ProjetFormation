package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.entities.Membre;
import com.formation.service.MembreService;

@Controller
public class MembreControlleur {

	@Autowired
	private MembreService membreService;

	@RequestMapping("/membre")
	private String ajoutMembre(Model model) {
		
		Membre newMembre = new Membre();
		model.addAttribute("membre", newMembre);
		return "membre";
		
	}

}
