package com.dms.master;

import org.springframework.beans.factory.annotation.Autowired;

import com.dails.master.utils.MasterUtils;

public class MyTask {
	
	@Autowired
	private	MasterUtils masterUtils;
	
	
	public void bonusPayRetry() {
		
		System.err.println("hh"+masterUtils.isMaster());
		
	}
	
}
