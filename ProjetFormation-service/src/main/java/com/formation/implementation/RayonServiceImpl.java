package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.RayonDAO;
import com.formation.entities.Rayon;
import com.formation.service.RayonService;

@Service
@Transactional
public class RayonServiceImpl implements RayonService {

	@Autowired
	private RayonDAO rayonDao;

	@Override
	public void save(Rayon r)  throws Exception {
		// TODO Auto-generated method stub
		rayonDao.save(r);
	}

	@Override
	public void delete(Rayon r)  throws Exception{
		// TODO Auto-generated method stub
		rayonDao.delete(r);

	}

	@Override
	public List<Rayon> getAll()  throws Exception{
		// TODO Auto-generated method stub
		return rayonDao.getAll();
	}

	@Override
	public Rayon get(int id)  throws Exception{
		// TODO Auto-generated method stub
		return rayonDao.get(id);
	}

}
