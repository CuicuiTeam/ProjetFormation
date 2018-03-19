package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.CategorieDAO;
import com.formation.entities.Categorie;
import com.formation.entities.Membre;
import com.formation.service.CategorieService;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	@Override
	public Categorie getCategorieByNom(String nom) {
		// TODO Auto-generated method stub
		return categorieDAO.getCategorieByNom(nom);
	}

	@Override
	public Categorie get(int id) {
		// TODO Auto-generated method stub
		return categorieDAO.get(id);
	}
	
	public void save(Categorie c) {
		categorieDAO.save(c);
	}

	public List<Categorie> getAll(){
		return categorieDAO.getAll();
	}
	
	public void delete(Categorie c) {
		categorieDAO.delete(c);
	}
}
