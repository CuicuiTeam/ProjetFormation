package com.formation.dao;

import java.util.List;

public interface DAOPrincipal<T> {
	
	public void save(T t);
	public List<T> getAll();
	public T get(int id);
	public void delete(T t);

}
