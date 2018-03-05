
package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.PanierDAO;
import com.formation.entities.Panier;

@Repository
@Transactional
public class PanierDAOImpl extends DAOPrincipalImpl<Panier> implements PanierDAO {

}
