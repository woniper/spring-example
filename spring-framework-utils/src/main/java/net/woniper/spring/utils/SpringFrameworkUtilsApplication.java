package net.woniper.spring.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringFrameworkUtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkUtilsApplication.class, args);
	}

	@Bean
	public DemoClass demoClass() {
		return new DemoClass();
	}
}
