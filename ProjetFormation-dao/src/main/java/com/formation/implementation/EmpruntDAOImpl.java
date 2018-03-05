package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.EmpruntDAO;
import com.formation.entities.Emprunt;

@Repository
@Transactional
public class EmpruntDAOImpl extends DAOPrincipalImpl<Emprunt> implements EmpruntDAO {

}
