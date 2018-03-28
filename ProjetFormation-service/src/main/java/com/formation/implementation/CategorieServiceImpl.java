package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.CategorieDAO;
import com.formation.entities.Categorie;
import com.formation.service.CategorieService;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	@Override
	public Categorie getCategorieByNom(String nom)  throws Exception{
		// TODO Auto-generated method stub
		return categorieDAO.getCategorieByNom(nom);
	}

	@Override
	public Categorie get(int id)  throws Exception{
		// TODO Auto-generated method stub
		return categorieDAO.get(id);
	}
	
	public void save(Categorie c) throws Exception {
		categorieDAO.save(c);
	}

	public List<Categorie> getAll() throws Exception{
		return categorieDAO.getAll();
	}
	
	public void delete(Categorie c)  throws Exception{
		categorieDAO.delete(c);
	}
}
