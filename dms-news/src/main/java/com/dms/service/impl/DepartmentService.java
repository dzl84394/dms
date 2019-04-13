package com.dms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.DepartmentDao;
import com.dms.domain.Department;
import com.dms.service.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentDao dao;
	
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Department save(Department obj) {
		if (obj.getCreatedAt() == null) {
			obj.setCreatedAt(formatter.format(new Date()));
		}
		obj.setUpdatedAt(formatter.format(new Date()));
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public void delete(Department obj) {
		dao.delete(obj);			
	}

	@Override
	public Department findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Department findBySample(Department sample) {
		return null;
	}

	@Override
	public List<Department> findAll() {
		return (List<Department>) dao.findAll();
	}



	@Override
	public Page<Department> findAll(Pageable pageRequest) {
		return null;
	}

	





}
