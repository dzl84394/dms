package com.dms.dao;

import org.springframework.data.repository.CrudRepository;

import com.dms.domain.SUser;

public interface UserDao extends CrudRepository<SUser, Long> {
	
	SUser findByUsername(String name);
	
}
