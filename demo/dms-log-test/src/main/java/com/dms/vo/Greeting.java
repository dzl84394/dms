package com.dms.vo;

public class Greeting {
	private  long id;
    private  String content;

    public Greeting() {
    	System.err.println(">>>>>>>>>>>>>>Greeting======");
	}
    public Greeting(long id, String content) {
    	System.err.println(">>>>>>>>>>>>>>Greeting======22222");
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	
    
}
