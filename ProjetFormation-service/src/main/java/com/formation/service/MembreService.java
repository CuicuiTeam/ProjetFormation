package com.formation.service;

import java.util.List;

import com.formation.entities.Membre;
import com.formation.exception.ServiceException;

public interface MembreService {
	
	public Membre get(int id);
	
	public Membre findByEmail(String email);
	
	public Membre identification(String email, String password) throws Exception;

	public void save(Membre m);
	
	public void delete(Membre m);

	public String cryptageMdp(String password);

	public List<Membre> getAll();
	


}
