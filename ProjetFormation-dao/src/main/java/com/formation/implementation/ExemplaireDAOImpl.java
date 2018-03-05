
package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ExemplaireDAO;
import com.formation.entities.Exemplaire;

@Repository
@Transactional
public class ExemplaireDAOImpl extends DAOPrincipalImpl<Exemplaire> implements ExemplaireDAO {

}
