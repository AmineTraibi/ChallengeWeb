package com.ensa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.ensa.controller"})
@EntityScan("com.ensa.*")
@EnableJpaRepositories("com.ensa.dao")
public class WebChallenge1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebChallenge1Application.class, args);
	}
}
