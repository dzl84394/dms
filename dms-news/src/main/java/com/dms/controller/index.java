package com.dms.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.domain.Category;
import com.dms.domain.Department;
import com.dms.domain.Item;
import com.dms.domain.SUser;
import com.dms.service.ICategoryService;
import com.dms.service.IDepartmentService;
import com.dms.service.IItemService;
import com.dms.service.IUserService;
import com.google.common.base.Strings;


/**
 * 12345
 * @author dingzl
 *
 */

@Controller
public class index {
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  
	@Autowired																					
	private ICategoryService categoryService;	
	@Autowired																					
	private IDepartmentService departmentService;
	
	@Autowired																					
	private IItemService itemService;
	
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping(value = { "","/", "/index", "/home", "list" })
	public String index(Map<String, Object> map,HttpServletRequest request) {
		SUser user = userService.findCurrentUser(request);
		request.getSession().setAttribute("currentUser", user);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	

	@RequestMapping(value = { "data/categories" }) 
	@ResponseBody
	public List<Category> getCategories(HttpServletRequest request) throws Exception {
		String fatherStr = request.getParameter("father");
		Long father = 0L;
		if (!Strings.isNullOrEmpty(fatherStr)) {
			father = Long.parseLong(fatherStr);
		}
		List<Category> objs = categoryService.findByFather(father);
		return objs;
	}
	@RequestMapping(value = { "data/departments" }) 
	@ResponseBody
	public List<Department> getDepartments(HttpServletRequest request) throws Exception {
		List<Department> objs = departmentService.findAll();
		return objs;
	}
	
	@RequestMapping(value = { "data/items" }) 
	@ResponseBody
	public List<Item> getItems(HttpServletRequest request) throws Exception {
		List<Item> objs = itemService.findAll();
		return objs;
	}
	
}
