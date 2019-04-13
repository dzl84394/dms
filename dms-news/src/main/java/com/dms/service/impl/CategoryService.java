package com.dms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.CategoryDao;
import com.dms.domain.Category;
import com.dms.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryDao dao;
	
	
	@Override
	public Category save(Category obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public void delete(Category obj) {
		dao.delete(obj);			
	}

	@Override
	public Category findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Category findBySample(Category sample) {
		return null;
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) dao.findAll();
	}



	@Override
	public Page<Category> findAll(Pageable pageRequest) {
		return null;
	}

	


	@Override
	public List<Category> findByFather(Long father) {
		// TODO Auto-generated method stub
		return dao.findByFather(father);
	}



}
