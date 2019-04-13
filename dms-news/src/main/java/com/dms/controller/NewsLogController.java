package com.dms.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.dms.domain.NewsLog;
import com.dms.service.INewsLogService;

@Controller
@RequestMapping({ "/newsLog" })	
public class NewsLogController {


	@Autowired																					
	private INewsLogService service;	
	


	
	@RequestMapping(value = { "","index" }, method = { RequestMethod.GET })						
	public ModelAndView getAllObj(HttpServletRequest request) {		
		ModelAndView mav = new ModelAndView("newsLog/index");								
		List<NewsLog> objs = service.findAll();												
		mav.addObject("objs", objs);															
		return mav;																				
	}																							
																								
	@RequestMapping(value = { "show/{id}" }, method = { RequestMethod.GET })						
	public ModelAndView showObj(HttpServletRequest request,@PathVariable Long id) {
		   
		ModelAndView mav = new ModelAndView("newsLog/show");								
		NewsLog obj = service.findById(Long.valueOf(id));	
		mav.addObject("obj", obj);
		
		return mav;																				
	}																							
																								
	@RequestMapping(value = { "new","add" }, method = { RequestMethod.GET })						
	public ModelAndView newObj() {																
		NewsLog obj = new NewsLog();														
		ModelAndView mav = new ModelAndView("newsLog/new");								
		mav.addObject("obj", obj);															
		return mav;																				
	}																							
																								
	@RequestMapping(value = { "save" }, method = { RequestMethod.POST })						
	public String saveObj(@ModelAttribute("obj") NewsLog obj, RedirectAttributes redirectAttributes) {
		Long id = obj.getId();
	
		
		service.save(obj);																		
		redirectAttributes.addFlashAttribute("msg", "保存成功");								
		return "redirect:index";											
	}																							
																								
	@RequestMapping(value = { "edit" }, method = { RequestMethod.GET })						
	public ModelAndView editObj(@RequestParam("id") Long id) {								
		ModelAndView mav = new ModelAndView("newsLog/edit");								
		NewsLog obj = service.findById(id);													
		mav.addObject("obj", obj);															
		return mav;																				
	}																							
																								
																						
																								
	@RequestMapping(value = { "delete" }, method = { RequestMethod.GET })						
	public String deleteObj(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		service.delete(id);																		
		redirectAttributes.addFlashAttribute("msg", "删除成功");								
		return "redirect:index";															
	}	

	
	
	
}
