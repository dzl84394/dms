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


import com.dms.domain.Notice;
import com.dms.service.INoticeService;

@Controller
@RequestMapping({ "/notice" })	
public class NoticeController {


	@Autowired																					
	private INoticeService service;	
	


	
	@RequestMapping(value = { "","index" }, method = { RequestMethod.GET })						
	public ModelAndView getAllObj(HttpServletRequest request) {		
		ModelAndView mav = new ModelAndView("notice/index");								
		List<Notice> objs = service.findAll();												
		mav.addObject("objs", objs);															
		return mav;																				
	}																							
																								
	@RequestMapping(value = { "show/{id}" }, method = { RequestMethod.GET })						
	public ModelAndView showObj(HttpServletRequest request,@PathVariable Long id) {
		   
		ModelAndView mav = new ModelAndView("notice/show");								
		Notice obj = service.findById(Long.valueOf(id));	
		mav.addObject("obj", obj);
		
		return mav;																				
	}																							
																								
	@RequestMapping(value = { "new","add" }, method = { RequestMethod.GET })						
	public ModelAndView newObj() {																
		Notice obj = new Notice();	
		obj.setDtype("notice");
		ModelAndView mav = new ModelAndView("notice/new");								
		mav.addObject("obj", obj);															
		return mav;																				
	}																							
																								
	@RequestMapping(value = { "save" }, method = { RequestMethod.POST })						
	public String saveObj(@ModelAttribute("obj") Notice obj, RedirectAttributes redirectAttributes) {
		Long id = obj.getId();
	
		
		service.save(obj);																		
		redirectAttributes.addFlashAttribute("msg", "保存成功");								
		return "redirect:index";											
	}																							
																								
	@RequestMapping(value = { "edit" }, method = { RequestMethod.GET })						
	public ModelAndView editObj(@RequestParam("id") Long id) {								
		ModelAndView mav = new ModelAndView("notice/edit");								
		Notice obj = service.findById(id);													
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
