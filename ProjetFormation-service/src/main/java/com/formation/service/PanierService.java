package com.formation.service;

import java.util.List;

import com.formation.entities.Panier;

public interface PanierService {
	public Panier get(int id) throws Exception;
	public void save(Panier panier) throws Exception;
	public void delete(Panier panier) throws Exception;
	public List<Panier> getAll() throws Exception;

}
