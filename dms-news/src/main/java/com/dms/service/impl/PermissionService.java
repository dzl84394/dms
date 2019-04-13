package com.dms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.PermissionDao;
import com.dms.domain.Permission;
import com.dms.service.IPermissionService;

@Service
public class PermissionService implements IPermissionService {

	@Autowired
	private PermissionDao dao;
	
	
	@Override
	public Permission save(Permission obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public void delete(Permission obj) {
		dao.delete(obj);			
	}

	@Override
	public Permission findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Permission findBySample(Permission sample) {
		return null;
	}

	@Override
	public List<Permission> findAll() {
		return (List<Permission>) dao.findAll();
	}


	@Override
	public Page<Permission> findAll(Pageable pageRequest) {
		return null;
	}





}
