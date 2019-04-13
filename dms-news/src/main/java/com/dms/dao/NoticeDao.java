package com.dms.dao;

import org.springframework.data.repository.CrudRepository;
import com.dms.domain.Notice;

public interface NoticeDao extends CrudRepository<Notice, Long> {
}
