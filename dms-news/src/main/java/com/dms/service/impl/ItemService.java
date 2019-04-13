package com.dms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.ItemDao;
import com.dms.domain.Item;
import com.dms.service.IItemService;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemDao dao;
	
	
	@Override
	public Item save(Item obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public void delete(Item obj) {
		dao.delete(obj);			
	}

	@Override
	public Item findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Item findBySample(Item sample) {
		return null;
	}

	@Override
	public List<Item> findAll() {
		return (List<Item>) dao.findAll();
	}


	@Override
	public Page<Item> findAll(Pageable pageRequest) {
		return null;
	}

	





}
