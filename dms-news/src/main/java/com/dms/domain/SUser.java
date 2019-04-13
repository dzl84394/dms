package com.dms.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dms.utils.BaseConstants;

import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class SUser implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "ITEM_ID") private Item item;
	 */

	@OneToOne
	@JoinColumn(name="item_id" )
	private Item item;
	
	@OneToOne
	@JoinColumn(name="department_id" )
	private Department department;
	

	
	@Column
	private String email;//

	@Column
	private String username;
	@Column
	private String password;

	@Column
	private int signCount;//
	@Column
	private int signErrCount;// 超过6次，就死了

	@Column
	private int signIn;// 是否在线

	@Column
	private String officePhone;
	@Column
	private String mobile;

	@Column
	private String createdAt;
	@Column
	private String updatedAt;
	@Column
	private String deletedAt;

	@Column
	private boolean enabled;
	@Column
	private boolean credentialsNonExpired;

	@Column
	private boolean accountNonExpired;
	@Column
	private boolean accountNonLocked;

	@Column
	private Long temp1;
	@Column
	private Long temp2;
	@Column
	private Long temp3;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
//		List<Permission> roles = this.getPermissions();
//		for (Permission role : roles) {
//			auths.add(new SimpleGrantedAuthority(role.getClassName()));
//		}
		auths.add(new SimpleGrantedAuthority("role"+this.getItem().getName()));
		
		return auths;
	}
	
	public SUser() {
		SimpleDateFormat formatter = new SimpleDateFormat(BaseConstants._time_format_space);
		this.createdAt = formatter.format(new Date());
		this.updatedAt = formatter.format(new Date());
		this.enabled = true;
		this.credentialsNonExpired = true;
		this.accountNonExpired = true;
		this.accountNonLocked = true;
	}

}
