package com.arpit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;

import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableIntegration
public class Application {

	@Bean
	Environment env() {
		return new Environment();
	}

	@Bean
	Reactor createReactor(Environment env) {
		return Reactors.reactor()
				.env(env)
				.dispatcher(Environment.THREAD_POOL)
				.get();
	}

	@Autowired
	private Reactor reactor;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
//		System.out.println("Get the beans");
		
//		String[] beans = context.getBeanDefinitionNames();
//		Arrays.sort(beans);
//		for(String bean : beans) {
//			System.out.println("Bean: "+bean);
//		}
	}
}
