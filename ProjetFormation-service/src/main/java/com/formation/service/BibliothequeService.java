package com.formation.service;

import java.util.List;

import com.formation.entities.Bibliotheque;

public interface BibliothequeService {
	public List<Bibliotheque> getAll() throws Exception;

	public void save(Bibliotheque biblio) throws Exception;

	public Bibliotheque get(int id) throws Exception;

	public void delete(Bibliotheque biblio) throws Exception;
	
	

}
