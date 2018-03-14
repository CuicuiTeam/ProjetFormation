package com.formation.controlleur;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.entities.Membre;
import com.formation.service.MembreService;

@Controller
public class MembreControlleur {

	@Autowired
	private MembreService membreService;

	@RequestMapping(value = "/admin/inscription", method = RequestMethod.GET)
	private String ajoutMembre(Model model) {

		Membre newMembre = new Membre();
		model.addAttribute("newMembre", newMembre);
		return "inscription";
	}

	@RequestMapping(value = "/admin/inscription", method = RequestMethod.POST)
	private String ajoutMembre(@ModelAttribute("newMembre") Membre newMembre, Model model) {
		String pass = membreService.cryptageMdp(newMembre);
		newMembre.setPassword(pass);
		if (membreService.findByEmail(newMembre.getEmail()) != null) {
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
	private String connexionMembre(@ModelAttribute("login") Membre newMembre, Model model) {

		String pass = membreService.cryptageMdp(newMembre);
		newMembre.setPassword(pass);
		if (membreService.identification(newMembre.getEmail(), newMembre.getPassword()) == null) {
			model.addAttribute("msgErreur", "Veuillez saisir un identifiant et un mot de passe valide");
			return "connexion";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/supprimerMembre", method = RequestMethod.GET)
	private String supprMembre(Model model) {

		model.addAttribute("membres", membreService.getAll());
		return "adminmembresuppr";
	}

	@RequestMapping(value = "/supprimerMembre", method = RequestMethod.POST)
	private String supprMembre(HttpServletRequest request) {
		Membre membre = membreService.get(Integer.parseInt(request.getParameter("membreId")));
		membreService.delete(membre);
		return "redirect:/supprimerMembre";

	}

	@RequestMapping(value = "/editmembre", method = RequestMethod.GET)
	private String editMembre(HttpServletRequest request, Model model) {
		Membre membre = membreService.get(Integer.parseInt(request.getParameter("idMembre")));
		model.addAttribute("edit", membre);
		return "admineditmembre";

	}

	@RequestMapping(value = "/editmembre", method = RequestMethod.POST)
	private String editMembre(@ModelAttribute("edit") Membre membre, @RequestParam(value = "idMembre") int idMembre) {
		membre.setId(idMembre);
		membreService.save(membre);
		return "redirect:/supprimerMembre";

	}
}
