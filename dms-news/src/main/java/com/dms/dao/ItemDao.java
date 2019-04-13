package com.dms.dao;

import org.springframework.data.repository.CrudRepository;
import com.dms.domain.Item;

public interface ItemDao extends CrudRepository<Item, Long> {
}
