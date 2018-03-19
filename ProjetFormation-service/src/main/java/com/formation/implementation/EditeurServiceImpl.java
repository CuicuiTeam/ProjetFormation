package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.EditeurDAO;
import com.formation.entities.Categorie;
import com.formation.entities.Editeur;
import com.formation.service.EditeurService;

@Service
@Transactional
public class EditeurServiceImpl implements EditeurService {

	@Autowired
	private EditeurDAO editeurDAO;

	@Override
	public List<Editeur> getAll() {
		// TODO Auto-generated method stub
		return editeurDAO.getAll();
	}

	public Editeur get(int id) {
		return editeurDAO.get(id);
	}

	public void save(Editeur e) {
		editeurDAO.save(e);
	}
	
	public void delete(Editeur e) {
		editeurDAO.delete(e);
	}
}
