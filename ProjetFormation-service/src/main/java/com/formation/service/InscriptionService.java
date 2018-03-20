package com.formation.service;

import java.util.List;

import com.formation.entities.Inscription;;

public interface InscriptionService {
	public Inscription get(int id) throws Exception;
	public void save(Inscription inscription) throws Exception;
	public void delete(Inscription inscription) throws Exception;
	public List<Inscription> getAll() throws Exception;

	public List<Inscription> getInscriptionById(List<Integer> ids) throws Exception;
	
}
