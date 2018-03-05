package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.EditeurDAO;
import com.formation.entities.Editeur;

@Repository
@Transactional
public class EditeurDAOImpl extends DAOPrincipalImpl<Editeur> implements EditeurDAO {

}
