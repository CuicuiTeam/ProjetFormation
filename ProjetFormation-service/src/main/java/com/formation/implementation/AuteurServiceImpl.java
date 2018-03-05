package com.formation.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.AuteurDAO;
import com.formation.entities.Auteur;
import com.formation.service.AuteurService;

@Service
public class AuteurServiceImpl implements AuteurService {

	@Autowired
	private AuteurDAO auteurDAO;

	@Override
	public Auteur getAuteurByNom(String nom) {
		// TODO Auto-generated method stub
		return auteurDAO.getAuteurByNom(nom);
	}

}
