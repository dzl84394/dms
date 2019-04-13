package com.dms.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dms.dao.NewsDao;
import com.dms.domain.News;
import com.dms.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsDao dao;

	@Override
	public News save(News obj) {
		dao.save(obj);
		return obj;
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void delete(News obj) {
		dao.delete(obj);
	}

	@Override
	public News findById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public News findBySample(News sample) {
		return null;
	}

	@Override
	public List<News> findAll() {
		return (List<News>) dao.findAll();
	}

	@Override
	public Page<News> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Page<News> findAll(final  News obj, Pageable pageable) {

		/*
		 * ExampleMatcher matcher = ExampleMatcher.matching();// 构建对象,必须是一句语句么
		 * if (obj.getStatus() != null) {
		 * matcher.matchingAll().withMatcher("status",
		 * GenericPropertyMatchers.exact()); }
		 * 
		 * matcher.matchingAll().withIgnorePaths("id","lock","tobackCount",
		 * "hits","pubHits","pubHits","createdAt","updatedAt","orders",
		 * "orderIndex","onEnglish","on_index","onImportantNews","onTop"); //
		 * 忽略属性：是否关注。因为是基本类型，需要忽略掉
		 * 
		 * Example<News> ex = Example.of(obj, matcher); Page<News> objs =
		 * dao.findAll(ex, pageable);
		 */

		Specification<News> spec = new Specification<News>() { // 查询条件构造

			@Override
			public Predicate toPredicate(Root<News> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> status = root.get("status");
				Path<String> categoryId = root.get("categoryId");
				Path<String> category2Id = root.get("category2Id");
				
				Predicate predicate = cb.conjunction();
	            
				if (!"0".equals(obj.getStatus())) {
					predicate.getExpressions().add(
	                        cb.equal(status,  obj.getStatus() )
	                );
				}
				if (!"0".equals(obj.getCategoryId())) {
					predicate.getExpressions().add(
	                        cb.equal(categoryId,  obj.getCategoryId() )
	                );
				}
				
				if (!"0".equals(obj.getCategory2Id())) {
					predicate.getExpressions().add(
	                        cb.equal(category2Id,  obj.getCategory2Id() )
	                );
				}

//				Predicate p = cb.and(p1, p2);
				return predicate;

			}

		};
		Page<News> objs = dao.findAll(spec, pageable);
		return objs;
	}

	@Override
	public News findUp(Long id) {
		return dao.findUp(id);
	}

	@Override
	public News findDown(Long id) {
		return dao.findDown(id);
	}

}
