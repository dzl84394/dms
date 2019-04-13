package com.dms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dms.domain.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {

	List<Category> findByFather(Long father);
}
