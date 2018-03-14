

package com.formation.dao;

import java.io.Serializable;
import java.util.List;

import com.formation.entities.Livre;

public interface DAOPrincipal<T> {
	
	public void save(T t);
	public List<T> getAll();
	public T get(int id);
	public void delete(T t);

}

