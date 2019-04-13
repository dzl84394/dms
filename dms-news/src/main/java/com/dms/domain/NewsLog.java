package com.dms.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dms.utils.BaseConstants;

import lombok.Data;

@Data
@Entity
@Table(name = "t_news_log")
public class NewsLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String  dtype;//news .notice.
	
	@Column
	private Long objId;// comment: "新闻类型"

	@Column
	private Long userId;// comment: "标题"
	@Column
	private String action;// comment: 动作
	@Column
	private String note;// comment: 原因

	@Column
	private String createdAt;// "
	
	public NewsLog() {
		SimpleDateFormat formatter = new SimpleDateFormat(BaseConstants._time_format_space);
		this.createdAt = formatter.format(new Date());
		
	}

}
