package com.dms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dms.domain.News;
import com.dms.domain.NewsLog;
import com.dms.domain.SUser;
import com.dms.service.INewsLogService;
import com.dms.service.INewsService;
import com.dms.service.IUserService;
import com.dms.utils.BaseConstants;
import com.google.common.base.Strings;

@Controller
@RequestMapping({ "/news" })
public class NewsController {

	@Autowired
	private INewsService service;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private INewsLogService logService;

	static SimpleDateFormat sdf = new SimpleDateFormat(BaseConstants._time_format_space);
	
	@RequestMapping(value = { "", "index" }, method = { RequestMethod.GET })
	public ModelAndView getAllObj(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("news/index");
		SUser user = userService.findCurrentUser(request);
		if(user.getItem().getId()==15){
			mav = new ModelAndView("news/pubindex");
		}
	
		
		List<News> objs =null;// service.findAll(SortTools.basicSort("desc","orders"));
		mav.addObject("objs", objs);
		
		
		return mav;
	}
	
	@RequestMapping(value = { "allObj" })
	@ResponseBody
	public Page<News> allObj(HttpServletRequest request) {
		
		
		String currentPage = (String) request.getParameter("currentPage");
		String size = (String) request.getParameter("pageSize");
		
		String categoryId = (String) request.getParameter("categoryId");
		String category2Id = (String) request.getParameter("category2Id");
		
		String departmentId = (String) request.getParameter("departmentId");
		String status = (String) request.getParameter("status");
		News obj = new News("haha");
		obj.setStatus(status);
		obj.setCategoryId(Long.parseLong(categoryId));
		obj.setCategory2Id(Long.parseLong(category2Id));
		obj.setDepartmentId(Long.parseLong(departmentId));
		
		
		
		
		if (Strings.isNullOrEmpty(currentPage)) {
			currentPage = "0";
		}
		if (Strings.isNullOrEmpty(size)) {
			size="5";
		}
		Pageable pageable =new PageRequest(Integer.parseInt(currentPage),Integer.parseInt(size), Sort.Direction.DESC, "orders");
		
		Page<News> nPage = service.findAll(obj,pageable);
		
		return nPage;
	}
	

	@RequestMapping(value = { "show/{id}" }, method = { RequestMethod.GET })
	public ModelAndView showObj(HttpServletRequest request, @PathVariable Long id) {

		ModelAndView mav = new ModelAndView("news/show");
		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		if(user.getItem().getId()==15){
			mav = new ModelAndView("news/pubshow");
		}
		
		News obj = service.findById(id);
		mav.addObject("obj", obj);

		return mav;
	}

	@RequestMapping(value = { "new", "add" }, method = { RequestMethod.GET })
	public ModelAndView newObj(HttpServletRequest request) {
		News obj = new News();
		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		
		obj.setWriterName(user.getUsername());
		obj.setWriterId(user.getId());
		ModelAndView mav = new ModelAndView("news/new");
		mav.addObject("obj", obj);
		return mav;
	}

	@RequestMapping(value = { "save" }, method = { RequestMethod.POST })
	public String saveObj(@ModelAttribute("obj") News obj, RedirectAttributes redirectAttributes) {
		
		
		Long id = obj.getId();

		service.save(obj);
		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "edit" }, method = { RequestMethod.GET })
	public ModelAndView editObj(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("news/edit");
		News obj = service.findById(id);
		mav.addObject("obj", obj);
		return mav;
	}
	
	@RequestMapping(value = { "pubedit" }, method = { RequestMethod.GET })
	public ModelAndView pubedit(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("news/pubedit");
		News obj = service.findById(id);
		mav.addObject("obj", obj);
		return mav;
	}
	
	@RequestMapping(value = { "pubsave" }, method = { RequestMethod.POST })
	public String pubsave(@ModelAttribute("obj") News obj, RedirectAttributes redirectAttributes) {
		
		
		Long id = obj.getId();
		News obj2 = service.findById(id);
		obj2.setPubHits(obj.getPubHits());
		obj2.setPubTime(obj.getPubTime());
		obj2.setUpdatedAt(sdf.format(new Date()));
		
		service.save(obj2);
		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "delete" }, method = { RequestMethod.GET })
	public String deleteObj(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		service.delete(id);
		redirectAttributes.addFlashAttribute("msg", "删除成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "submit" }, method = { RequestMethod.GET })
	public String submit(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		News news = service.findById(id);
		news.setStatus("待审核");
		service.save(news);
		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "lock" }, method = { RequestMethod.GET })
	public String lock(@RequestParam("id") Long id,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		News news = service.findById(id);
		news.setLock(1);
		service.save(news);
		redirectAttributes.addFlashAttribute("msg", "保存成功");
		
		
		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		NewsLog log = new NewsLog();
		log.setObjId(id);
		log.setDtype("news");
		log.setAction("锁定");
		log.setCreatedAt(sdf.format(new Date()));
		log.setUserId(user.getId());
		logService.save(log);
		
		
		return "redirect:index";
	}

	@RequestMapping(value = { "unLock" }, method = { RequestMethod.GET })
	public String unLock(@RequestParam("id") Long id,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		News news = service.findById(id);
		news.setLock(0);
		service.save(news);
		
		
		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		NewsLog log = new NewsLog();
		log.setObjId(id);
		log.setDtype("news");
		log.setAction("解除锁定");
		log.setCreatedAt(sdf.format(new Date()));
		log.setUserId(user.getId());
		logService.save(log);
		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	/**
	 * 得到批准
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = { "approved" }, method = { RequestMethod.GET })
	public String approved(@RequestParam("id") Long id,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		News news = service.findById(id);
		news.setStatus("发布");
		
		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		news.setPostName(user.getUsername());
		news.setPostId(user.getId());
		
		news.setUpdatedAt(sdf.format(new Date()));
		news.setPubTime( sdf.format(new Date()));
		
		service.save(news);
		
		NewsLog log = new NewsLog();
		log.setObjId(id);
		log.setDtype("news");
		log.setAction("审核通过");
		log.setCreatedAt(sdf.format(new Date()));
		log.setUserId(user.getId());
		logService.save(log);

		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	/**
	 * 否认
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = { "deniedEdit" }, method = { RequestMethod.GET })
	public ModelAndView deniedEdit(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("news/deniedEdit");
		// News obj = service.findById(id);
		NewsLog log = new NewsLog();
		log.setObjId(id);
		log.setDtype("news");
		mav.addObject("obj", log);
		return mav;
	}

	/**
	 * 否认
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = { "denied" }, method = { RequestMethod.POST })
	public String denied(@ModelAttribute("obj") NewsLog obj,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		News news = service.findById(obj.getObjId());
		news.setStatus("草稿");
		service.save(news);

		SUser user = (SUser) request.getSession().getAttribute("currentUser");
		obj.setAction("拒绝");
		obj.setCreatedAt(sdf.format(new Date()));
		obj.setUserId(user.getId());
		logService.save(obj);

		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "up" }, method = { RequestMethod.GET })
	public String up(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		// 找到时间小于我的，第一个，
		News news = service.findById(id);

		News news2 = service.findUp(news.getOrders());
		if (news2!=null) {
			long order2 = news2.getOrders();
			news.setOrders(order2 + 1);
		}else{
			news.setOrders(news.getOrders() + 1);
		}
		
		service.save(news);

		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}

	@RequestMapping(value = { "down" }, method = { RequestMethod.GET })
	public String down(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		// 找到时间小于我的，第一个，
		News news = service.findById(id);

		News news2 = service.findDown(news.getOrders());
		if (news2!=null) {
			long order2 = news2.getOrders();
			news.setOrders(order2 -1);
		}else{
			news.setOrders(news.getOrders() -1);
		}
		service.save(news);

		redirectAttributes.addFlashAttribute("msg", "保存成功");
		return "redirect:index";
	}
}
