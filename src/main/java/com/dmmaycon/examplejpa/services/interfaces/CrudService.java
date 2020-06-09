package com.dmmaycon.examplejpa.services.interfaces;

import java.util.List;

public interface CrudService <T, K>{

	public List<T> all();
	public T byId(K id);
	public T insert(T entity);
	public T update(T entity);
	public void delete(T entity);
	public void deleteById(K id);
}
