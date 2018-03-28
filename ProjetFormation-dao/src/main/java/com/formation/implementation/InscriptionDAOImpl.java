package com.formation.implementation;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.formation.dao.InscriptionDAO;
import com.formation.entities.Inscription;

@Repository
@Transactional
public class InscriptionDAOImpl extends DAOPrincipalImpl<Inscription> implements InscriptionDAO {

}
