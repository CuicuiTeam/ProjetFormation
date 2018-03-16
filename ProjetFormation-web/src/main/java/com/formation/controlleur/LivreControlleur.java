package com.formation.controlleur;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.LivreDTO;
import com.formation.entities.Livre;
import com.formation.service.AuteurService;
import com.formation.service.CategorieService;
import com.formation.service.EditeurService;
import com.formation.service.LivreService;

@RestController
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


	@GetMapping(value = "/livres")
	public List<LivreDTO> listerLivres() {
		List<LivreDTO> resultats = new ArrayList<LivreDTO>();
		List<Livre> listeLivres = livreService.getAll();

		listeLivres.forEach(livre -> {
			LivreDTO livreDto = new LivreDTO(livre.getTitre(), livre.getDescription(), livre.getPrix(),
					livre.getDatePublication(), livre.getImagePath(), livre.isPopular(), livre.isPeriodic(),
					livre.getEditeur().getId(), livre.getCategorie().getId());
			List<Integer> authorIds = new ArrayList<Integer>();

			livre.getAuteurs().forEach(auteur -> authorIds.add(auteur.getId()));
			livreDto.setAuteursId(authorIds);

			resultats.add(livreDto);
		});

		return resultats;
	}

	@PostMapping(value = "/ajoutlivre")
	public void ajouterLivre(@RequestBody LivreDTO livreDto) {

		Livre newLivre = new Livre(livreDto.getTitre(), livreDto.getDescription(), livreDto.getPrix(),
				livreDto.getDatePublication(), livreDto.getImagePath(), livreDto.isPeriodic(), livreDto.isPopular());
		newLivre.setEditeur(editeurService.get(livreDto.getEditeurId()));
		newLivre.setCategorie(categorieService.get(livreDto.getCategorieId()));
		newLivre.setAuteurs(auteurService.getAuteursById(livreDto.getAuteursId()));
		livreService.save(newLivre);
	}

	@RequestMapping(value = "/editlivre", method = RequestMethod.GET)
	private String editMembre(HttpServletRequest request, Model model) {
		Livre livre = livreService.get(Integer.parseInt(request.getParameter("idLivre")));
		model.addAttribute("edit", livre);
		return "admineditlivre";

	}


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

	@RequestMapping(value = "/editlivre", method = RequestMethod.POST)
	private String editMembre(@ModelAttribute("edit") Livre livre, @RequestParam(value = "idLivre") int idLivre) {
		livre.setId(idLivre);
		livreService.save(livre);
		return "redirect:/supprimer";

	}
}
