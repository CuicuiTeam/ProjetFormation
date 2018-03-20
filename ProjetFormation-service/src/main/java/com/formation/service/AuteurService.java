package com.formation.service;

import java.util.List;

import com.formation.entities.Auteur;

public interface AuteurService {

	public Auteur getAuteurByNom(String nom) throws Exception;
	public Auteur get(int id) throws Exception;
	public void save(Auteur auteur) throws Exception;
	public void delete(Auteur auteur) throws Exception;
	public List<Auteur> getAll() throws Exception;
	public List<Auteur> getAuteurAll() throws Exception;
	public List<Auteur> getAuteursById(List<Integer> ids) throws Exception;

}
