package com.formation.service;

import java.util.List;

import com.formation.entities.Categorie;
import com.formation.entities.Membre;

public interface CategorieService {

	public Categorie getCategorieByNom(String nom);

	public Categorie get(int id);
	
	public void save(Categorie c);
	
	public List<Categorie> getAll();
	
	public void delete(Categorie c);
}
