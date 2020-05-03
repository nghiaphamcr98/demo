package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {


	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {		
		logger.info("starting...");
		System.out.println("D:/Back-end/halocom/demo/conf/");
		new SpringApplicationBuilder(DemoApplication.class)
			.properties("spring.config.location:" + "D:/Back-end/halocom/demo/conf/").build().run(args);
	}

}
