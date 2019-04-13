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
@Table(name = "t_news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long categoryId;// comment: "新闻类型"
	@Column
	private Long category2Id;// comment: "新闻类型"

	@Column
	private String title;// comment: "标题"
	@Column
	private String bottomTitle;// comment: "副标题"
	@Column
	private String upTitle;// comment: "肩标题"
	@Column
	private String authorName;// comment: "作者名"
	@Column
	private String cameramanName;// comment: "摄影师"
	
	@Column
	private String departmentName;//落款
	
	
	@Column
	private String body;// comment: "正文"
	@Column
	private String keywords;// comment: "关键词"

	
	@Column
	private Long departmentId;// comment: "发布单位ID"
	
	@Column
	private Long writerId;
	@Column
	private String writerName;// comment: "录稿人姓名"
	@Column
	private Long postId;// 发布者ID
	@Column
	private String postName;// comment: "发布人姓名"

	@Column
	private String status;// 状态 【草稿、待审核、发布】 动作有 【提交，审核通过，审核不通过，冻结】
	@Column
	private int lock;// 0是展示，1是不展示
	@Column
	private int tobackCount;// default: 0, comment: "退回次数"
	@Column
	private int hits;// 真实的点击次数"
	@Column
	private int pubHits;//展示次数
	@Column
	private String pubWhere;// ", comment: "发布地址"
	@Column
	private String pubUrl;// ", comment: "发布URL"


	@Column
	private String createdAt;// "
	@Column
	private String updatedAt;// "
	@Column
	private String pubTime;// ", comment: "发布时间"

	

	@Column
	private long orders;// 顺序
	
	@Column
	private long orderIndex;// 首页显示顺序


	@Column
	private boolean onEnglish;// ", default: 0, null: false, comment: "是否英文稿件"
	
	@Column
	private boolean onIndex;// 是否上首页(0:不上,1:上)
	@Column
	private boolean onImportantNews; // comment: "是否要闻(0:不是,1:是)"
	@Column
	private boolean onTop;// ", default: 0, comment: "是否头条"
	
	@Column
	private String topContent;// ", comment: "头条内容"

	@Column
	private String homePageImage;// ", comment: "首页显示图片"
	@Column
	private String homePageLocation;// ", default: 0, null: false, comment:
	// "首页显示位置（0: 不显示在首页, 1: 显示在校园要闻， 2:
	// 显示在校园快讯, 3: 显示在深度报道， 4: 显示媒体华理, 5:
	// 显示在图说华丽）"
	public News(String createdAt) {
		
	}
	public News() {
		SimpleDateFormat formatter = new SimpleDateFormat(BaseConstants._time_format_space);
		this.createdAt = formatter.format(new Date());
		this.updatedAt = formatter.format(new Date());
		this.orders = System.currentTimeMillis();
		this.orderIndex = System.currentTimeMillis();
		this.status = "草稿";
	}

}
