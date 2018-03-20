package com.formation.service;

import java.util.List;

import com.formation.entities.Emprunt;

public interface EmpruntService {
	
	public Emprunt get(int id) throws Exception;
	public void save(Emprunt emprunt) throws Exception;
	public void delete(Emprunt emprunt) throws Exception;
	public List<Emprunt> getAll() throws Exception;

}
