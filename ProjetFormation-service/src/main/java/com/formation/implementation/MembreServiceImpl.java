package com.formation.implementation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.MembreDAO;
import com.formation.entities.Membre;
import com.formation.service.MembreService;

@Service
public class MembreServiceImpl implements MembreService{
	
	@Autowired
	private MembreDAO membreDAO;
	
	@Override
	public Membre identification(String email, String password) {
		return membreDAO.identification(email, password);
	}

	@Override
	public void save(Membre m) {
		// TODO Auto-generated method stub
		membreDAO.save(m);
	}

	public String cryptageMdp(Membre membre) {

		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(membre.getPassword().getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return generatedPassword;

	}

	@Override
	public Membre get(int id) {
		return membreDAO.get(id);
	}

	@Override
	public Membre findByEmail(String email) {
		return membreDAO.findMembreByEmail(email);
	}

	@Override
	public void delete(Membre m) {
		membreDAO.delete(m);
	}

}
