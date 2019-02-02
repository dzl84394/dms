package com.dms.domain;

public class Order {
	String userId;
		boolean needAudit;//是否需要审核价格
		
		String thirdId;//外部订单号
		
		String priceInfo;//
		boolean automatic;//自动续期，默认flase
		
		String goodsInfo;
		boolean needdelivery;//是否需要交付
		String delieryUserId;
		
		String promotionInfo;//营销
		

		//核价状态
		//支付状态
		//交付状态
		//订单状态
}
