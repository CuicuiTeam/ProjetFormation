package com.formation.service;

import java.util.List;

import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;

public interface LivreService {

	public List<Livre> getLivreByCat(Categorie cat) throws Exception;

	public List<Livre> getPeriodiques() throws Exception;

	public List<Livre> getLivreByAuteur(Auteur auteur) throws Exception;

	public List<Livre> getLivreByRecherche(String recherche)  throws Exception;

	public List<Livre> getLivreRecommandes() throws Exception;

	public void save(Livre livre) throws Exception;

	public void delete(Livre livre) throws Exception;

	public List<Livre> getAll() throws Exception;

	public Livre get(int id) throws Exception;

}
