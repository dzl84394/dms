package com.dms.service;

import java.util.List;

import com.dms.domain.Category;
import com.dms.domain.SUser;

public interface ICategoryService extends BaseService<Category> {
	
	public List<Category> findByFather(Long father);
	
}
