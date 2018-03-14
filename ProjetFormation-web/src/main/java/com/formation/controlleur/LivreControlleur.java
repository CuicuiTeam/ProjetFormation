package com.formation.controlleur;

import javax.servlet.http.HttpServletRequest;

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
import com.formation.service.EditeurService;
import com.formation.service.LivreService;

@Controller
public class LivreControlleur {

	@Autowired
	private LivreService livreService;

	@Autowired
	private AuteurService auteurService;

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private EditeurService editeurService;

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
	private String listeByCategorie(@PathVariable(value = "cat") String cat, Model model) {
		model.addAttribute("livres", livreService.getLivreByCat(categorieService.getCategorieByNom(cat)));
		model.addAttribute("titre", categorieService.getCategorieByNom(cat).getNom());
		return "accueil";
	}

	@RequestMapping("/auteur/{aut}")
	private String listeByAuteur(@PathVariable(value = "aut") String aut, Model model) {

		model.addAttribute("livres", livreService.getLivreByAuteur(auteurService.getAuteurBySlug(aut)));
		model.addAttribute("titre",auteurService.getAuteurBySlug(aut).getPrenom() + " " +  auteurService.getAuteurBySlug(aut).getNom() );
		model.addAttribute("auteur", auteurService.getAuteurBySlug(aut));
		return "auteur";

	}

	@RequestMapping(value = "/recherche", method = RequestMethod.POST)
	private String resultatRecherche(HttpServletRequest request, Model model) {
		String motRecherche = request.getParameter("motRecherche");
		model.addAttribute("livres", livreService.getLivreByRecherche(motRecherche));
		model.addAttribute("titre", "Recherche : " + motRecherche);
		return "accueil";
	}

	@ModelAttribute("Livre")
	public Livre getLivre() {

		return new Livre();
	}

	@RequestMapping(value = "/ajoutlivre", method = RequestMethod.GET)
	private String ajouterLivre(Model model) {

		Livre newLivre = new Livre();
		model.addAttribute("livre", newLivre);
		// model.addAttribute("editeurs", editeurService.getAll());
		return "adminaddlivre";
	}

	@RequestMapping(value = "/ajoutlivre", method = RequestMethod.POST)
	private String ajouterLivre(Livre newLivre, HttpServletRequest request) {
		// newLivre.setEditeur(editeurService.get(Integer.parseInt(request.getParameter("editeur"))));
		// System.out.println(request.getParameter("editeur"));
		livreService.save(newLivre);
		return "redirect:/";
	}

	// @RequestMapping(value = "/ajoutlivre", method = RequestMethod.POST, params =
	// "btnAdd=Ajouter puis créer un nouveau livre")
	// private String ajouterNewLivre(@ModelAttribute("livre") Livre newLivre, Model
	// model) {
	// livreService.save(newLivre);
	// model.addAttribute("livre", new Livre());
	// return "adminaddlivre";
	// }

	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	private String supprLivre(Model model) {

		model.addAttribute("livres", livreService.getAll());
		return "adminsuppr";
	}

	@RequestMapping(value = "/supprimer", method = RequestMethod.POST)
	private String supprLivre(HttpServletRequest request) {
		System.out.println(request.getParameter("livreId"));
		Livre livre = livreService.get(Integer.parseInt(request.getParameter("livreId")));
		livreService.delete(livre);
		return "redirect:/supprimer";

	}

	@RequestMapping("/livre/{liv}")
	private String Livre(@PathVariable(value = "liv") String liv, Model model) {

		model.addAttribute("livre", livreService.getLivreBySlug(liv));
		model.addAttribute("titre", livreService.getLivreBySlug(liv).getTitre());
		return "livre";

	}
}
