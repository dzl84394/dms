package com.dms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.ext.INewsDaoExt;
import com.dms.domain.News;

@Transactional
public class NewsDaoImpl implements INewsDaoExt {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public News findUp(Long orders) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);

		criteria.add(Restrictions.gt("orders", orders));

		criteria.addOrder(Order.desc("orders"));

		criteria.setMaxResults(1);
		List<News> newss = criteria.list();
		if (newss !=null && newss.size()>0) {
			return newss.get(0);
		}
		return null;
	}

	@Override
	public News findDown(Long orders) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);

		criteria.add(Restrictions.lt("orders", orders));

		criteria.addOrder(Order.desc("orders"));

		criteria.setMaxResults(1);
		List<News> newss = criteria.list();
		if (newss !=null && newss.size()>0) {
			return newss.get(0);
		}
		return null;
	}


}
