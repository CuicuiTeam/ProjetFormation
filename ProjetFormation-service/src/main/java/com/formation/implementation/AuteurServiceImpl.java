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
	public Auteur getAuteurByNom(String nom) throws Exception {
		return auteurDAO.getAuteurByNom(nom);
	}
	
	@Override
	public List<Auteur> getAll() throws Exception {
		return auteurDAO.getAll();
	} 
	
	public List<Auteur> getAuteurAll() throws Exception {
		return auteurDAO.getAuteurAll();
	}

	@Override
	public List<Auteur> getAuteursById(List<Integer> ids) throws Exception {
		return auteurDAO.getAll().stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
	}

	@Override
	public Auteur get(int id)  throws Exception{
		return auteurDAO.get(id);
	}

	@Override
	public void save(Auteur auteur)  throws Exception{
		auteurDAO.save(auteur);
	}
	
	public void delete(Auteur auteur) throws Exception {
		auteurDAO.delete(auteur);
	}

}
