package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.entities.Livre;
import com.formation.service.AuteurService;
import com.formation.service.CategorieService;
import com.formation.service.LivreService;

@Controller
public class LivreControlleur {

	@Autowired
	private LivreService livreService;

	@Autowired
	private AuteurService auteurService;

	@Autowired
	private CategorieService categorieService;

	@RequestMapping("/")
	private String accueil(Model model) {

		model.addAttribute("livres", livreService.getLivreRecommandes());
		model.addAttribute("titre", "Accueil");
		return "accueil";
	}

	@RequestMapping("/periodiques")
	private String listePeriodiques(Model model) {

		model.addAttribute("livres", livreService.getPeriodiques());
		model.addAttribute("titre", "Périodiques");
		return "accueil";
	}

	@RequestMapping("/categorie/{cat}")
	private String listeByCategorie(@PathVariable(value="cat")String cat, Model model) {
		model.addAttribute("livres", livreService.getLivreByCat(categorieService.getCategorieByNom(cat)));
		model.addAttribute("titre", categorieService.getCategorieByNom(cat).getNom());
		return "accueil";
	}

	@RequestMapping("/auteur/{aut}")
	private String listeByAuteur(@PathVariable(value="aut") String aut, Model model) {

		model.addAttribute("livres", livreService.getLivreByAuteur(auteurService.getAuteurBySlug(aut)));
		model.addAttribute("titre", "Recherche par auteur");
		model.addAttribute("auteur", auteurService.getAuteurBySlug(aut));
		return "auteur";

	}

	@RequestMapping("/recherche/{rech}")
	private String listeRecherche(@PathVariable String rech, Model model) {

		model.addAttribute("livres", livreService.getLivreByRecherche(rech));
		return "recherche";
	}
	
	///////////////////////////////////////////////
	@RequestMapping(value = "/recherche/{rech}", method = RequestMethod.GET)
	private String recupRecherche(@PathVariable String motRecherche, Model model) {
		model.addAttribute("motRecherche", motRecherche);
		return "accueil";
	}
	
	@RequestMapping(value = "/recherche/{rech}", method = RequestMethod.POST)
	private String resultatRecherche(@ModelAttribute("motRecherche") String motRecherche, Model model) {
		model.addAttribute("livres", livreService.getLivreByRecherche(motRecherche));
		model.addAttribute("titre", "Recherche : " + motRecherche);
		return "accueil";
		}

	@RequestMapping(value = "/ajoutlivre", method = RequestMethod.GET)
	private String ajouterLivre(Model model) {
		
		Livre newLivre = new Livre();
		model.addAttribute("livre", newLivre);
		return "adminaddlivre";
	}

	@RequestMapping(value = "/ajoutlivre", method = RequestMethod.POST, params = "btnadd=Ajouter et revenir à l'accueil")
	private String ajouterLivre(@ModelAttribute("livre") Livre newLivre, Model model) {

		livreService.save(newLivre);
		return "redirect:/";
	}

	@RequestMapping(value = "/ajoutlivre", method = RequestMethod.POST, params = "btnadd=Ajouter puis créer un nouveau livre")
	private String ajouterNewLivre(@ModelAttribute("livre") Livre newLivre, Model model) {

		livreService.save(newLivre);
		return "adminaddlivre";
	}

}

