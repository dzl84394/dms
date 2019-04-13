package com.dms.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.dms.dao.UserDao;
import com.dms.domain.SUser;
import com.dms.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao dao;

	@Override
	public SUser save(SUser obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void delete(SUser obj) {
		dao.delete(obj);
	}

	@Override
	public SUser findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public SUser findBySample(SUser sample) {

		return null;
	}

	@Override
	public List<SUser> findAll() {
		return (List<SUser>) dao.findAll();
	}

	@Override
	public Page<SUser> findAll(Pageable pageRequest) {
		return null;
	}


	@Override
	public SUser findByName(String name) {
		return dao.findByUsername(name);
	}

	@Override
	public SUser findCurrentUser(HttpServletRequest request) {
		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		if (user != null) {
			return user;
		}
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			user = dao.findByUsername(userDetails.getUsername());
			request.getSession().setAttribute("currentUser", user);
			return user;
		} catch (Exception e) {
			return null;
		}

	}


}
