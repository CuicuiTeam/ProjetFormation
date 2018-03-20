package com.formation.service;

import java.util.List;

import com.formation.entities.Rayon;

public interface RayonService {

	public void save(Rayon r) throws Exception;

	public void delete(Rayon r) throws Exception;

	public List<Rayon> getAll() throws Exception;

	public Rayon get(int id) throws Exception;

}
