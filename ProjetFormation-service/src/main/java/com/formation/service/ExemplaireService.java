package com.formation.service;

import java.util.List;

import com.formation.entities.Exemplaire;


public interface ExemplaireService {

	public Exemplaire get(int id);
	public void save(Exemplaire exemplaire);
	public void delete(Exemplaire exemplaire);
	public List<Exemplaire> getAll();
}
