package com.formation.service;

import java.util.List;

import com.formation.entities.Membre;

public interface MembreService {
	
	public Membre get(int id) throws Exception;
	
	public Membre findByEmail(String email) throws Exception;
	
	public Membre identification(String email, String password) throws Exception;

	public void save(Membre m) throws Exception;
	
	public void delete(Membre m) throws Exception;

	public String cryptageMdp(String password) throws Exception;

	public List<Membre> getAll() throws Exception;

}
