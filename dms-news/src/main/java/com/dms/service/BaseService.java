package com.dms.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface BaseService<T> {
	T save(T obj);

	void delete(Long id) ;

	void delete(T obj) ;

	T findById(Long id);

	T findBySample(T sample);

	List<T> findAll();

	
//	List<T> findAll(Sort  sample);
	
	Page<T> findAll(Pageable pageRequest);


}
