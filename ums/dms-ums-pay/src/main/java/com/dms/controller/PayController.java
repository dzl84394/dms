package com.dms.controller;

public class PayController {

	// 支付
	// 如果是混合支付，一定要走订单，把内部虚拟货币先预扣，然后再扣外面的，如果外面失败了，要判断订单失败，把虚拟货币给交付回去
	public String pay() {
		return "";
	}
	// 打赏

	public String reward() {
		return "";
	}

	// 红包
	public String redPacket() {
		return "";
	}

	// 退款
	public String cancelPay() {
		return "";
	}

	
	/**
	 * 苹果 回调接口
	 * @return
	 */
	public String callBackIap() {
		return "";
	}
	/**
	 * 微信 回调接口
	 * @return
	 */
	public String callBackeWechat() {
		return "";
	}
	/**
	 * 支付宝 回调接口
	 * @return
	 */
	public String callBackeAliPay() {
		return "";
	}
	
	
	/**
	 *  支付ID查询
	 * @return
	 */
		public String getPays() {
			return "";
		}
	/**
	 *  userid查询历史支付记录
	 * @return
	 */
	public String getPayByUserId() {
		return "";
	}
}
