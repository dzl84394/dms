package com.dms.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PickerRegexTest {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		String string = "{\"customEvent\": [{\"eventName\": \"MARKETING_ACTIVITY\",\"eventParams\": {\"activityCode\": \"PRIZE-SJL1G-lXJBo0321\",\"type\":\"MARKETING_EXPOSE\"}}, { \"eventName\": \"native_action\",\"du\": \"0\",\"timestamp\": \"1552530153640\",\"eventParams\": { \"provinceCode\": \"20\",\"cityId\": \"0668\", \"promotionID\": \"\", \"eventNo\": \"1\" }}],\"sdkSessionInfo\": {\"clientId\": \"b3b60b7107926536d11b9181a3be416a\", \"udid\": \"b3b60b7107926536d11b9181a3be416a\",\"androidId\": \"a6eaddd06afa97aa\", \"serialNO\": \"ONGI55P7JRKVDAPZ\", \"installationID\": \"ffffffff-f52e-d041-0000-0000000000001552530105234\", \"sdkpkg\": \"\", \"appVersion\": \"5.5.8.1\",  \"os\": \"AD\", \"phoneMode\": \"PBBT00\",  \"sdkversion\": \"3.2.3\", \"osversion\": \"27\",  \"phoneBrand\": \"OPPO\", \"account\": \"13828645453\", \"accountType\": \"0\", \"imei\": \"\", \"userId\": \"186854708\", \"uploadTs\": \"1552530153681\", \"promotion\": \"\" }}";
//	 849477afc7b921e0c1bb6a145ce88625|0|20180101000000||||1|||
//	 2d4f360cee243c66aaacc67115a4d490|0|20180101000000||1bc315a3b2ce4ee001ac2777a507bf85||1|||

//		Pattern pattern = Pattern.compile("^.*\\|.*\\|.*\\|.*\\|.+\\|.*\\|.*\\|.*\\|.*\\|$");
		
		Pattern pattern = Pattern.compile(".*MARKETING_ACTIVITY.*PRIZE-SJL1G-lXJBo0321.*");
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			System.out.println("=====" + matcher.group());
		}
		
		
		
	}
}
