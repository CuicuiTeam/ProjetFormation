
package com.formation.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.RayonDAO;
import com.formation.entities.Rayon;

@Repository
@Transactional
public class RayonDAOImpl extends DAOPrincipalImpl<Rayon> implements RayonDAO {

}
