package com.formation.controlleur;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.AuteurDTO;
import com.formation.dto.LivreDTO;
import com.formation.entities.Auteur;
import com.formation.entities.Livre;
import com.formation.exception.ServiceException;
import com.formation.mapper.EditeurMapper;
import com.formation.service.AuteurService;
import com.formation.service.CategorieService;
import com.formation.service.EditeurService;
import com.formation.service.LivreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

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
	
	@Autowired
	EditeurMapper editeurMapper;

	//	@RequestMapping("/periodiques")
	//	private String listePeriodiques(Model model) {
	//
	//		model.addAttribute("livres", livreService.getPeriodiques());
	//		model.addAttribute("titre", "Périodiques");
	//		return "accueil";
	//	}
	//
	//	@RequestMapping("/categorie/{cat}")
	//	private String listeByCategorie(@PathVariable(value = "cat") String cat, Model model) {
	//		model.addAttribute("livres", livreService.getLivreByCat(categorieService.getCategorieByNom(cat)));
	//		model.addAttribute("titre", categorieService.getCategorieByNom(cat).getNom());
	//		return "accueil";
	//	}

	//	@RequestMapping("/auteur/{aut}")
	//	private String listeByAuteur(@PathVariable(value = "aut") String aut, Model model) {
	//
	//		model.addAttribute("livres", livreService.getLivreByAuteur(auteurService.getAuteurBySlug(aut)));
	//		model.addAttribute("titre",
	//				auteurService.getAuteurBySlug(aut).getPrenom() + " " + auteurService.getAuteurBySlug(aut).getNom());
	//		model.addAttribute("auteur", auteurService.getAuteurBySlug(aut));
	//		return "auteur";
	//
	//	}

	//	@RequestMapping(value = "/recherche", method = RequestMethod.POST)
	//	private String resultatRecherche(HttpServletRequest request, Model model) {
	//		String motRecherche = request.getParameter("motRecherche");
	//		model.addAttribute("livres", livreService.getLivreByRecherche(motRecherche));
	//		model.addAttribute("titre", "Recherche : " + motRecherche);
	//		return "accueil";
	//	}

	@ModelAttribute("Livre")
	public Livre getLivre() {

		return new Livre();
	}

	@GetMapping(value = "/livre/recommandes")
	public Resultat listerRecommandes() {
		List<LivreDTO> listeLivre = new ArrayList<LivreDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Livre> listeLivres = livreService.getLivreRecommandes();

			listeLivres.forEach(livre -> {
				LivreDTO livreDto = new LivreDTO(livre.getTitre(), livre.getDescription(), livre.getPrix(),
						livre.getDatePublication(), livre.getImagePath(), livre.isPopular(), livre.isPeriodic(),
						editeurMapper.editeurToEditeurDTO(livre.getEditeur()), livre.getCategorie().getId());
				livreDto.setId(livre.getId());
				List<Integer> authorIds = new ArrayList<Integer>();
				livre.getAuteurs().forEach(auteur -> authorIds.add(auteur.getId()));
				livreDto.setAuteursId(authorIds);

				listeLivre.add(livreDto);
				resultat.setPayload(listeLivre);
			});
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@GetMapping(value = "/livre")
	public Resultat listerLivres() {
		List<LivreDTO> listeLivre = new ArrayList<LivreDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Livre> listeLivres = livreService.getAll();
 
			listeLivres.forEach(livre -> {
				LivreDTO livreDto = new LivreDTO(livre.getTitre(), livre.getDescription(), livre.getPrix(),
						livre.getDatePublication(), livre.getImagePath(), livre.isPopular(), livre.isPeriodic(),
						editeurMapper.editeurToEditeurDTO(livre.getEditeur()), livre.getCategorie().getId());
				livreDto.setId(livre.getId());
				List<Integer> authorIds = new ArrayList<Integer>();
				livre.getAuteurs().forEach(auteur -> authorIds.add(auteur.getId()));
				livreDto.setAuteursId(authorIds);

				listeLivre.add(livreDto);
				resultat.setPayload(listeLivre);
			});
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}
	
	@GetMapping(value = "/livre/{id}")
	private Resultat getLivre(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			Livre livre = livreService.get(id);
			LivreDTO livreDto = new LivreDTO(livre.getTitre(), livre.getDescription(), livre.getPrix(),
					livre.getDatePublication(),livre.getImagePath(), livre.isPopular(), livre.isPeriodic(),
					editeurMapper.editeurToEditeurDTO(livre.getEditeur()), livre.getCategorie().getId() );
			resultat.setPayload(livreDto);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;

	}

	@PutMapping(value = "/livre", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat ajouterLivre(@RequestBody LivreDTO livreDto) {
		Resultat resultat = new Resultat();
		try {
			Livre newLivre = new Livre(livreDto.getTitre(), livreDto.getDescription(), livreDto.getPrix(),
					livreDto.getDatePublication(), livreDto.getImagePath(), livreDto.isPeriodic(), livreDto.isPopular());
//			newLivre.setEditeur(editeurService.get(livreDto.getEditeurId()));
//			newLivre.setCategorie(categorieService.get(livreDto.getCategorieId()));
//			newLivre.setAuteurs(auteurService.getAuteursById(livreDto.getAuteursId()));
			livreService.save(newLivre);
			resultat.setPayload(livreDto);
			resultat.setSuccess(true); 
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@PostMapping(value = "/livre")
	public Resultat editerLivre(@RequestBody LivreDTO livreDto) {
		Resultat resultat = new Resultat();
		try {
			Livre livre = new Livre();
			livre.setId(livreDto.getId());
			livre.setTitre(livreDto.getTitre());
			livre.setDescription(livreDto.getDescription());
			livre.setPrix(livreDto.getPrix());
			livre.setDatePublication(livreDto.getDatePublication());
			livre.setPopular(livreDto.isPopular());
			livre.setImagePath(livreDto.getImagePath());
			livre.setEditeur(editeurService.get(livreDto.getEditeurDto().getId()));
			livre.setCategorie(categorieService.get(livreDto.getCategorieId()));
			List<Auteur> auteurs = new ArrayList<>();
			for (int i = 0; i < livreDto.getAuteursId().size(); i++) {
				auteurs.add(auteurService.get(i));
			}
			livre.setAuteurs(auteurs);

			livreService.save(livre);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}


	@DeleteMapping(value = "/livre/{id}")
	private Resultat supprLivre(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			Livre livre = livreService.get(id);
			livreService.delete(livre);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;

	}

	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void getImageAsByteArray(@RequestParam String imagePath, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		System.out.println(imagePath);
		InputStream in = request.getServletContext().getResourceAsStream("/ressources/images/" + imagePath);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		IOUtils.copy(in, response.getOutputStream());
	}
	// @RequestMapping("/livre/{liv}")
	// private String Livre(@PathVariable(value = "liv") String liv, Model model) {
	//
	// model.addAttribute("livre", livreService.getLivreBySlug(liv));
	// model.addAttribute("titre", livreService.getLivreBySlug(liv).getTitre());
	// return "livre";
	//
	// }

}
