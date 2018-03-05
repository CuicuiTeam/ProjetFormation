package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CategorieDAO;
import com.formation.entities.Categorie;

@Repository
@Transactional
public class CategorieDAOImpl extends DAOPrincipalImpl<Categorie> implements CategorieDAO {

}
