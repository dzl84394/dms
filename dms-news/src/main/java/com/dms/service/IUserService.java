package com.dms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dms.domain.SUser;

public interface IUserService extends BaseService<SUser> {
	public SUser findByName(String username);
	public SUser findCurrentUser(HttpServletRequest request);
}
