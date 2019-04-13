package com.dms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.NewsLogDao;
import com.dms.domain.NewsLog;
import com.dms.service.INewsLogService;

@Service
public class NewsLogService implements INewsLogService {

	@Autowired
	private NewsLogDao dao;
	
	
	@Override
	public NewsLog save(NewsLog obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public void delete(NewsLog obj) {
		dao.delete(obj);			
	}

	@Override
	public NewsLog findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public NewsLog findBySample(NewsLog sample) {
		return null;
	}

	@Override
	public List<NewsLog> findAll() {
		return (List<NewsLog>) dao.findAll();
	}


	@Override
	public Page<NewsLog> findAll(Pageable pageRequest) {
		return null;
	}

	





}
