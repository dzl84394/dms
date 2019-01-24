package com.dms.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MyPostConstruct {
	@PostConstruct
	private void init() {
		System.err.println(">>>>>>>>>>>>>>PostConstruct=======");
	}
}
