package com.dms.dao.ext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dms.domain.News;
import com.dms.domain.SUser;

public interface INewsDaoExt  {
	
	
	News findUp(Long id);
	News findDown(Long id);
}
