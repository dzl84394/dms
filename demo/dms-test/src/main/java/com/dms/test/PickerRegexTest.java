package com.dms.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PickerRegexTest {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		String string = "rest.AuthorizeRestController - {\\\"hostName\\\":\\\"SJ-AUTHORIZATION-10-150-31-15\\\",\\\"msg\\\":\\\"[label]-{\"}\",\"@version\":\"1";
//	 849477afc7b921e0c1bb6a145ce88625|0|20180101000000||||1|||
//	 2d4f360cee243c66aaacc67115a4d490|0|20180101000000||1bc315a3b2ce4ee001ac2777a507bf85||1|||

//		Pattern pattern = Pattern.compile("^.*\\|.*\\|.*\\|.*\\|.+\\|.*\\|.*\\|.*\\|.*\\|$");
		
		Pattern pattern = Pattern.compile("(?<=(SuspendRestController|ResumeRestController|RevokeRestController|AuthorizeRestController) - ).*\\[label\\].*(?=\",\"@version)");
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			System.out.println("=====" + matcher.group());
		}
		
		
		
	}
}
