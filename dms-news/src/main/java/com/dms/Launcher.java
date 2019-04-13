package com.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@Controller
@ComponentScan("com.dms")
public class Launcher extends SpringBootServletInitializer {


	public static void main(String[] args) throws Exception {
		// 打印服务启动信息
		// CommonTools.printMode();
		// SpringApplication server = new SpringApplication(Launcher.class);
		// // 服务启动
		// server.run(args);

		SpringApplication.run(Launcher.class);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Launcher.class);
	}


	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}
}
