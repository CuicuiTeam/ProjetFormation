package com.formation.service;

import java.util.List;

import com.formation.entities.Rayon;

public interface RayonService {

	public void save(Rayon r);

	public void delete(Rayon r);

	public List<Rayon> getAll();

	public Rayon get(int id);

}
