package com.dms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.NoticeDao;
import com.dms.domain.Notice;
import com.dms.service.INoticeService;

@Service
public class NoticeService implements INoticeService {

	@Autowired
	private NoticeDao dao;
	
	
	@Override
	public Notice save(Notice obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public void delete(Notice obj) {
		dao.delete(obj);			
	}

	@Override
	public Notice findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Notice findBySample(Notice sample) {
		return null;
	}

	@Override
	public List<Notice> findAll() {
		return (List<Notice>) dao.findAll();
	}


	@Override
	public Page<Notice> findAll(Pageable pageRequest) {
		return null;
	}

	




}
