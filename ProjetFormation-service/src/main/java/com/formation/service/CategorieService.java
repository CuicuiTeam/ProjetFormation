package com.formation.service;

import java.util.List;

import com.formation.entities.Categorie;
import com.formation.entities.Membre;

public interface CategorieService {

	public Categorie getCategorieByNom(String nom) throws Exception;

	public Categorie get(int id) throws Exception;
	
	public void save(Categorie c) throws Exception;
	
	public List<Categorie> getAll() throws Exception;
	
	public void delete(Categorie c) throws Exception;
}
