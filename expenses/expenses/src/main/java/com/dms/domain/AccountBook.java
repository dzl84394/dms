package com.dms.domain;

/**
 * 帐套
 * @author zlding
 *
 */
public class AccountBook {

	private Integer id;
	private Integer teamId;//企业id
	private Integer operator;//会计用户
	
	private String name;//帐套名字
	private Integer titleTemplateId;//会计科目
	
//	private  会计年度
	//开始月份
	//
	private String createTime;
	private String lastTime;
}
