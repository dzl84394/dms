package com.dms.domain;

import java.util.Map;

public class DeliveryItem {
	String itemId;// 业务系统生成的子项Id
	String name;// 交付物名称
	String handler;// 交付执行系统枚举(AAA等)
	String desc;// 描述
	Map<String, String> data;// 交付数据
//	Authorization authorization; // 授权信息
}
