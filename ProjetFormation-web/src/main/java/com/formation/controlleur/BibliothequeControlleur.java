package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.service.BibliothequeService;

@Controller
public class BibliothequeControlleur {
	
	@Autowired
	private BibliothequeService bibliothequeService;
	
	@RequestMapping("/bibliotheques")
	private String bibliotheques (Model model) {
		model.addAttribute("bibliotheques", bibliothequeService.getAll());
		return "bibliotheques";
	}

}
