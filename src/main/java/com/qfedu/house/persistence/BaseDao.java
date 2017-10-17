package com.qfedu.house.persistence;

import java.io.Serializable;
import java.util.List;

public interface BaseDao <E, K extends Serializable> {
	
	K save(E entity);
	
	void delete(E entity);
	
	boolean deleteById(K id);
	
	void update(E entity);
	
	E findById(K id);
	
	List<E> findAll();
}
