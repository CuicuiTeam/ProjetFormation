package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.BibliothequeDAO;
import com.formation.entities.Bibliotheque;

@Repository
@Transactional
public class BibliothequeDAOImpl extends DAOPrincipalImpl<Bibliotheque> implements BibliothequeDAO {

}
