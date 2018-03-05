package com.formation.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formation.dao.CategorieDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;
import com.formation.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	@Override
	public Categorie getCategorieByNom(String nom) {
		// TODO Auto-generated method stub
		return categorieDAO.getCategorieByNom(nom);
	}

}
