package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import com.example.demo.api.repository.CustomerRepository;
//import  org.springframework.boot.web.servlet.server.ServletWebServerFactory;

@SpringBootApplication//(scanBasePackages = {"com.example.demo","com.example.demo.api.model","com.example.demo.api.repository", "com.example.demo.api.controller"})
//@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
//@ComponentScan(basePackages = {"com.example.demo.api.controller.CustomerController"})
public class DemoApplication  {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//System.out.println(DemoApplication.class.getName());
	}
}