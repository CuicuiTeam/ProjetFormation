package com.formation.service;

import java.util.List;

import com.formation.entities.Emprunt;

public interface EmpruntService {
	
	public Emprunt get(int id);
	public void save(Emprunt emprunt);
	public void delete(Emprunt emprunt);
	public List<Emprunt> getAll();

}
