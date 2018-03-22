package com.formation.controlleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.MembreDTO;
import com.formation.entities.Membre;
import com.formation.exception.ServiceException;
import com.formation.service.MembreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;
import com.formation.viewmodel.IdentifiantsVM;

@RestController
public class LoginControlleur {

	@Autowired
	private MembreService membreService;


	@PostMapping(value="/connexion", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat connexionMembre(@RequestBody IdentifiantsVM identifiants, HttpServletRequest request) {
		Resultat resultat = new Resultat();
		try {
			Membre membre = membreService.identification(identifiants.getEmail(), identifiants.getPassword());
			HttpSession session = request.getSession();
			MembreDTO membreDto = new MembreDTO(membre.getId(), membre.getNom(), membre.getPrenom(), "", membre.getAdresse(), membre.getVille(), membre.getCodePostal(), membre.getTelephone(), membre.getEmail(), membre.isAdmin());
			session.setAttribute("USER", membreDto);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
			resultat.setPayload(membreDto);
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

	@PostMapping(value="/deconnexion", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat deconnexionMembre(HttpServletRequest request) {
		Resultat resultat = new Resultat();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		resultat.setSuccess(true);
		resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
		resultat.setPayload("Logout OK");

		return resultat;

	}
}
