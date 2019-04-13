package com.dms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.dms.dao.ext.INewsDaoExt;
import com.dms.domain.News;

public interface NewsDao extends JpaSpecificationExecutor<News>,JpaRepository<News, Long>,INewsDaoExt {
}
