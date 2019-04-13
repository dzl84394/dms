package com.dms.dao;

import org.springframework.data.repository.CrudRepository;
import com.dms.domain.NewsLog;

public interface NewsLogDao extends CrudRepository<NewsLog, Long> {
}
