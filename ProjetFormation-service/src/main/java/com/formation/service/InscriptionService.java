package com.formation.service;

import java.util.List;

import com.formation.entities.Inscription;;

public interface InscriptionService {
	public Inscription get(int id);
	public void save(Inscription inscription);
	public void delete(Inscription inscription);
	public List<Inscription> getAll();

	public List<Inscription> getInscriptionById(List<Integer> ids);
	
}
