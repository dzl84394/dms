package com.dms.controller;

public class PayController {

	
	//支付
		//如果是混合支付，一定要走订单，把内部虚拟货币先预扣，然后再扣外面的，如果外面失败了，要判断订单失败，把虚拟货币给交付回去
		public String pay() {
			return "";
		}
	//打赏
	
		public String reward() {
			return "";
		}
		
	// 红包
		public String redpacket() {
			return "";
		}
	//退款
		public String cancelPay() {
			return "";
		}
	//支付ID查询
		public String getPays() {
			return "";
		}
	//回调接口
		//苹果有报文上传，还要再验签，再判断
	
		//微信和支付宝是服务器直接返还，
		public String callBackIap() {
			return "";
		}
		public String callBackeWechat() {
			return "";
		}
		public String callBackeAliPay() {
			return "";
		}
		
		
	//userid查询历史支付记录
		public String getPayByUserId() {
			return "";
		}
}
