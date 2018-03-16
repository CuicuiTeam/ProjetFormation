package com.formation.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.dao.ExemplaireDAO;
import com.formation.entities.Exemplaire;
import com.formation.service.ExemplaireService;

public class ExemplaireServiceImpl implements ExemplaireService{
	
	@Autowired
	private ExemplaireDAO exemplaireDao;

	@Override
	public Exemplaire get(int id) {
		return exemplaireDao.get(id);
	}

	@Override
	public void save(Exemplaire exemplaire) {
		exemplaireDao.save(exemplaire);
	}

	@Override
	public void delete(Exemplaire exemplaire) {
		exemplaireDao.delete(exemplaire);
	}

	@Override
	public List<Exemplaire> getAll() {
		return exemplaireDao.getAll();
	}


	@Override
	public List<Exemplaire> getExemplaireById(List<Integer> ids) {
		return exemplaireDao.getAll().stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
	}

}
