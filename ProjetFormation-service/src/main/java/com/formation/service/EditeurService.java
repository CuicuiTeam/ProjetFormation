package com.formation.service;

import java.util.List;

import com.formation.entities.Editeur;

public interface EditeurService {

	public List<Editeur> getAll() throws Exception;

	public Editeur get(int id) throws Exception;
	
	public void save(Editeur e) throws Exception;
	
	public void delete(Editeur e) throws Exception;

}
