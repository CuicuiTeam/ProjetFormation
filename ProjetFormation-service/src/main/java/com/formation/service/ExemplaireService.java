package com.formation.service;

import java.util.List;

import com.formation.entities.Exemplaire;


public interface ExemplaireService {

	public Exemplaire get(int id) throws Exception;
	public void save(Exemplaire exemplaire) throws Exception;
	public void delete(Exemplaire exemplaire) throws Exception;
	public List<Exemplaire> getAll() throws Exception;

	public List<Exemplaire> getExemplaireById(List<Integer> ids) throws Exception;
}
