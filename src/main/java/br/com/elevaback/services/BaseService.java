package br.com.elevaback.services;

import java.util.List;

public interface BaseService<T> {

	public T findById(Long id);
	
	public void save(T baseDto);
	
	public List<T> findAll();
	
	public void delete(Long id);
}
