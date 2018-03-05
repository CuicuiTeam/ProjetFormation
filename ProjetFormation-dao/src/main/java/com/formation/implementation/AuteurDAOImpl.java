package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.AuteurDAO;
import com.formation.entities.Auteur;

@Repository
@Transactional
public class AuteurDAOImpl extends DAOPrincipalImpl<Auteur> implements AuteurDAO {

}
