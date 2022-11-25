package com.example.IPL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class IplApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplApplication.class, args);
	}


}
