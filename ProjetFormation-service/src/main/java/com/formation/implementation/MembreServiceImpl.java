package com.formation.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.dao.MembreDAO;
import com.formation.entities.Membre;
import com.formation.service.MembreService;

public class MembreServiceImpl implements MembreService{
	
	@Autowired
	private MembreDAO membreDAO;
	
	@Override
	public Membre identification(String email, String password) {
		return membreDAO.identification(email, password);
	}

}
