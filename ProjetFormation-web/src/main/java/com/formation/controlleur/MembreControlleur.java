package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.entities.Membre;
import com.formation.service.MembreService;

@Controller
public class MembreControlleur {

	@Autowired
	private MembreService membreService;

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	private String ajoutMembre(Model model) {

		Membre newMembre = new Membre();
		model.addAttribute("newMembre", newMembre);
		return "inscription";
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	private String ajoutMembre(@ModelAttribute("newMembre") Membre newMembre, Model model) {
		String pass;
		pass = membreService.cryptageMdp(newMembre);
		newMembre.setPassword(pass);
		if (membreService.getMembreByMail(newMembre.getEmail()) == true) {
			model.addAttribute("msgErreur", "Cet email est déjà utilisé");
			newMembre.setPassword("");
			return "inscription";
		} else {
		membreService.save(newMembre);
		return "redirect:/";
		}
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	private String connexionMembre(Model model) {

		Membre newMembre = new Membre();
		model.addAttribute("login", newMembre);
		return "connexion";
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	private String connexionMembre(@ModelAttribute("newMembre") Membre newMembre, Model model) {

		String pass;
		pass = membreService.cryptageMdp(newMembre);
		newMembre.setPassword(pass);
		if (membreService.identification(newMembre.getEmail(), newMembre.getPassword()) == null) {
			model.addAttribute("msgErreur", "Veuillez saisir un identifiant et un mot de passe valide");
			return "connexion";
		} else {
			return "redirect:/";
		}
	}

}
