package com.formation.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.AuteurDAO;
import com.formation.entities.Auteur;
import com.formation.service.AuteurService;

@Service
@Transactional
public class AuteurServiceImpl implements AuteurService {

	@Autowired
	private AuteurDAO auteurDAO;

	@Override
	public Auteur getAuteurByNom(String nom) {
		// TODO Auto-generated method stub
		return auteurDAO.getAuteurByNom(nom);
	}
	
	@Override
	public Auteur getAuteurBySlug(String slug) {
		// TODO Auto-generated method stub
		return auteurDAO.getAuteurBySlug(slug);
	}
	
	@Override
	public List<Auteur> getAll() {
		return auteurDAO.getAll();
	} 
	
	public List<Auteur> getAuteurAll() {
		return auteurDAO.getAuteurAll();
	}

	@Override
	public List<Auteur> getAuteursById(List<Integer> ids) {
		// TODO Auto-generated method stub
		return auteurDAO.getAll().stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
	}

}
