package com.dms.service;

import java.util.Arrays;

public interface IDaemonService {

	/**
	 * 每天11点检查第二天要运营的任务，查出来
	 * 加入定时任务
	 * 当他们到点就去执行，生产订单
	 * 
	 * 生成订单之后，订单成功了，通知合约
	 * 如果是苹果，获取最后时间，来修改合约最后成功时间
	 * 如果是微信，支付宝，返回扣款状态
	 * 
	 */
	

	
}
