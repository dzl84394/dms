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
@Table(name = "d_permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String ability;//
	
	@Column
	private String className;
	
	@Column
	private String describe;
	
	@Column
	private String createdAt;
	@Column
	private String updatedAt;

}
