package com.boot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boot.sample.util.BeanUtil;

@SpringBootApplication
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootSampleApplication.class, args);
		BeanUtil.setApplicationContext(applicationContext);
	}
}
