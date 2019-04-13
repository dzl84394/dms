package com.dms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dms.domain.Item;
import com.dms.domain.Permission;
import com.dms.domain.SUser;
import com.dms.service.IItemService;
import com.dms.service.IPermissionService;
import com.dms.service.IUserService;
import com.google.common.base.Strings;

@Controller
@RequestMapping({ "/item" })
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private IUserService userService;

	@Autowired
	private IPermissionService permissionService;

	@RequestMapping(value = { "", "index" }, method = { RequestMethod.GET })
	public ModelAndView getAllObj(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("item/index");
		List<Item> objs = service.findAll();
		mav.addObject("objs", objs);
		SUser user = userService.findCurrentUser(request);
		request.getSession().setAttribute("currentUser", user);
		return mav;
	}

	@RequestMapping(value = { "show/{id}" }, method = { RequestMethod.GET })
	public ModelAndView showObj(HttpServletRequest request, @PathVariable Long id) {

		ModelAndView mav = new ModelAndView("item/show");
		Item obj = service.findById(Long.valueOf(id));
		mav.addObject("obj", obj);

		return mav;
	}

	@RequestMapping(value = { "new", "add" }, method = { RequestMethod.GET })
	public ModelAndView newObj() {
		Item obj = new Item();
		ModelAndView mav = new ModelAndView("item/new");
		mav.addObject("obj", obj);
		return mav;
	}

	@RequestMapping(value = { "save" }, method = { RequestMethod.POST })
	public String saveObj(@ModelAttribute("obj") Item obj, RedirectAttributes redirectAttributes) {
		Long id = obj.getId();

		service.save(obj);
		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "edit" }, method = { RequestMethod.GET })
	public ModelAndView editObj(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("item/edit");
		Item obj = service.findById(id);
		mav.addObject("obj", obj);
		return mav;
	}

	@RequestMapping(value = { "delete" }, method = { RequestMethod.GET })
	public String deleteObj(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		service.delete(id);
		redirectAttributes.addFlashAttribute("msg", "删除成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "authorize" }, method = { RequestMethod.GET })
	public ModelAndView authorize(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("item/authorize");
		Item obj = service.findById(id);
		mav.addObject("obj", obj);

		List<Permission> objs = permissionService.findAll();
		mav.addObject("objs", objs);

		List<Permission> permissions = obj.getPermissions();
		List<String> has = new ArrayList<>();
		if (permissions!=null&&permissions.size()>0) {
			for (Permission permission : permissions) {
				has.add(permission.getId().toString());
			}
		}
		
	 
		mav.addObject("has", has);
		return mav;
	}
	
	@RequestMapping(value = { "saveAuthorize" }, method = { RequestMethod.GET })
	@ResponseBody
	public String saveAuthorize(HttpServletRequest request) {
		String id = request.getParameter("id");
		String chk_value = request.getParameter("chk_value");
		Item obj = service.findById(Long.parseLong(id));
		obj.setPermissions(null);
		if (!Strings.isNullOrEmpty(chk_value)) {
			String[] chks = chk_value.split(",");
			List<Permission> permissions = new ArrayList<>();
			for (int i = 0; i < chks.length; i++) {
				Permission permission = permissionService.findById(Long.parseLong(chks[i]));
				permissions.add(permission);
			}
		
			obj.setPermissions(permissions);
		}
		
		service.save(obj);
		
		
		
		return "OK";
	}
	
	
	

}
