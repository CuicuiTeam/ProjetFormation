package com.formation.service;

import com.formation.entities.Categorie;

public interface CategorieService {

	public Categorie getCategorieByNom(String nom);

	public Categorie get(int id);
}
