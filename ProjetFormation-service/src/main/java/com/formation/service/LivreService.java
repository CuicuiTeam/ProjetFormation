package com.formation.service;

import java.util.List;

import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;

public interface LivreService {

	public List<Livre> getLivreByCat(Categorie cat);

	public List<Livre> getPeriodiques();

	public List<Livre> getLivreByAuteur(Auteur auteur);

	public List<Livre> getLivreByRecherche(String recherche) ;

	public List<Livre> getLivreRecommandes();

	public void save(Livre livre);

	public void delete(Livre livre);

	public List<Livre> getAll();

	public Livre get(int id);

}
