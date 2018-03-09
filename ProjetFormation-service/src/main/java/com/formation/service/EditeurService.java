package com.formation.service;

import java.util.List;

import com.formation.entities.Editeur;

public interface EditeurService {

	public List<Editeur> getAll();

	public Editeur get(int id);

}
