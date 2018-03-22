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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.AuteurDTO;
import com.formation.entities.Auteur;
import com.formation.exception.ServiceException;
import com.formation.mapper.LivreMapper;
import com.formation.service.AuteurService;
import com.formation.service.LivreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class AuteurControlleur {
	@Autowired
	private AuteurService auteurService;

	@Autowired
	private LivreService livreService;

	@Autowired
	LivreMapper livreMapper;

	@GetMapping(value = "/auteur")
	private Resultat listerAuteurs() {
		List<AuteurDTO> listeAuteurs = new ArrayList<AuteurDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Auteur> auteurs = auteurService.getAll();

			auteurs.forEach(a -> {
				AuteurDTO auteurDto = new AuteurDTO(a.getNom(), a.getPrenom(), a.getBiographie(), a.getImagePath());
				auteurDto.setId(a.getId());
				listeAuteurs.add(auteurDto);
				resultat.setPayload(listeAuteurs);
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

	@GetMapping(value = "/auteur/{id}")
	private Resultat getAuteur(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			Auteur auteur = auteurService.get(id);
			AuteurDTO auteurDto = new AuteurDTO(auteur.getNom(), auteur.getPrenom(), auteur.getBiographie(),
					auteur.getImagePath());
			auteurDto.setLivres(livreMapper.toDTOs(livreService.getLivreByAuteur(auteur)));
			resultat.setPayload(auteurDto);
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

	@PutMapping(value = "/auteur", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat ajoutAuteur(@RequestBody AuteurDTO auteurDto) {
		Resultat resultat = new Resultat();
		try {
			Auteur auteur = new Auteur(auteurDto.getNom(), auteurDto.getPrenom(), auteurDto.getBiographie(),
					auteurDto.getImagePath());
			auteurService.save(auteur);
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

	@PostMapping(value = "/auteur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat updateAuteur(@RequestBody AuteurDTO auteurDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			Auteur auteur = auteurService.get(id);
			auteur.setBiographie(auteurDto.getBiographie());
			auteur.setNom(auteurDto.getNom());
			auteur.setPrenom(auteurDto.getPrenom());
			auteur.setImagePath(auteurDto.getImagePath());

			auteurService.save(auteur);
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

	@DeleteMapping(value = "/auteur/{id}")
	private Resultat deleteAuteur(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			auteurService.delete(auteurService.get(id));
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

	@RequestMapping(value = "/imageauteur", method = RequestMethod.GET)
	public void getImageAsByteArray(@RequestParam String imagePath, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		System.out.println(imagePath);
		InputStream in = request.getServletContext().getResourceAsStream("/ressources/images/" + imagePath);
		System.out.println("=======" + in);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		IOUtils.copy(in, response.getOutputStream());
	}

}
