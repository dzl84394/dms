package com.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "d_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column private String name;
	@Column private String shortName;
	
	@Column private String contactUser;//联系人
	
	@Column private String contactPhone;//联系电话
	
	
	@Column private String createdAt;
	@Column private String updatedAt;
	
	
}


