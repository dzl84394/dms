package com.dms.dao;

import org.springframework.data.repository.CrudRepository;
import com.dms.domain.Department;

public interface DepartmentDao extends CrudRepository<Department, Long> {
}
