package com.dms.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dms.domain.News;

public interface INewsService extends BaseService<News> {
	
	News findUp(Long id);
	News findDown(Long id);
	Page<News> findAll(News sample, Pageable pageRequest);
}
