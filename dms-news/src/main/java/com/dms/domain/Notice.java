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

/**
 * 讲座报告
 * 
 * @author dingzl
 *
 */
@Data
@Entity
@Table(name = "t_notice")
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String dtype;//lecture notice
	@Column
	private String title;// 报告标题
	@Column
	private String place;// 地点
	@Column
	private String reporter;// 报告人姓名
	@Column
	private String time;// 报告时间
	@Column
	private String body;// 正文
	@Column
	private String note;// 备注
	@Column
	private String toUser;//受众
	
	@Column
	private String departmentName;//落款
	
	@Column
	private int  lock;//0是展示，1是不展示
	
	@Column
	private String status;//送审采用等标识列(0:草稿,1:已送审,2:已采用,3:未采用)
	
	
	@Column
	private String createdAt;
	@Column
	private String updatedAt;
	@Column
	private String pubtime;// 显示的时间
	
	@Column
	private int hits;//
	@Column
	private int pubHits;//展示次数
	@Column
	private int tobackCount;// default: 0, comment: "退回次数"
	
	
	@Column
	private Long writerId;
	@Column
	private String writerName;// comment: "录稿人姓名"
	@Column
	private Long postId;// 发布者ID
	@Column
	private String postName;// comment: "发布人姓名"
	@Column
	private Long departmentId;// 部门具体负责人姓名

	@Column
	private int english;// ", default: 0, null: false, comment: "是否英文稿件"


	
	@Column
	private String onIndex;// 是否上首页(0:不上,1:上)
	
	
	
	@Column
	private long orders;// 顺序
	
	@Column
	private long orderIndex;// 首页显示顺序

	
	@Column
	private String isSecret;
	public Notice() {
		SimpleDateFormat formatter = new SimpleDateFormat(BaseConstants._time_format_space);
		this.createdAt = formatter.format(new Date());
		this.updatedAt = formatter.format(new Date());
		this.orders = System.currentTimeMillis();
		this.orderIndex = System.currentTimeMillis();
		this.status = "草稿";
	}
}
