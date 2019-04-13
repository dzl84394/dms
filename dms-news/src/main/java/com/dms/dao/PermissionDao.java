package com.dms.dao;

import org.springframework.data.repository.CrudRepository;
import com.dms.domain.Permission;

public interface PermissionDao extends CrudRepository<Permission, Long> {
}
