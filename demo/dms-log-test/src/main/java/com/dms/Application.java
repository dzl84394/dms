package com.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.dms.*,com.dails.*"})
public class Application {

    public static void main(String[] args) {
    	
    	System.err.println(">>>>>>>>>>>>>>Application11111111111");
        SpringApplication.run(Application.class, args);


    	System.err.println(">>>>>>>>>>>>>>Application2222222222");
    }
}