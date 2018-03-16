package com.formation.service;

import java.util.List;

import com.formation.entities.Bibliotheque;

public interface BibliothequeService {
	public List<Bibliotheque> getAll();

	public void save(Bibliotheque biblio);

	public Bibliotheque get(int id);

	public void delete(Bibliotheque biblio);

}
