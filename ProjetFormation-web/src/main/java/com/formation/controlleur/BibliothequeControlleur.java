package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.entities.Bibliotheque;
import com.formation.service.BibliothequeService;

@Controller
public class BibliothequeControlleur {
	
	@Autowired
	private BibliothequeService bibliothequeService;
	
	@RequestMapping("/bibliotheques")
	private String bibliotheques (Model model) {
		model.addAttribute("bibliotheques", bibliothequeService.getAll());
		model.addAttribute("titre", "Bibliotheques");
		return "bibliotheques";
	}

	@RequestMapping(value = "/admin/ajoutBibliotheque", method = RequestMethod.GET)
	private String ajoutBibliotheque(Model model) {
		Bibliotheque biblio = new Bibliotheque();
		model.addAttribute("newBiblio", biblio);
		return "adminbiblio";
	}

	@RequestMapping(value = "/admin/ajoutBibliotheque", method = RequestMethod.POST)
	private String ajoutBibliotheque(@ModelAttribute("newBiblio") Bibliotheque biblio, Model model) {
		bibliothequeService.save(biblio);
		return "redirect:/";

	}

}
