package com.formation.service;

import com.formation.entities.Membre;

public interface MembreService {
	
	public Membre identification(String email, String password);
}
