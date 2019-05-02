package com.asg.subscriber.main;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.asg.subscriber.model.PhoneNumber;
import com.asg.subscriber.model.SubscriberCacheManager;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages= {"com.asg.subscriber"})
public class PhoneNumberServiceApplication implements ApplicationRunner {
	
	@Autowired
	private SubscriberCacheManager cache;

	public static void main(String[] args) {
		SpringApplication.run(PhoneNumberServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		cache.addCustomer("Jack", new HashSet(Arrays.asList(new PhoneNumber("0434888999"),new PhoneNumber("04445556667"))));
		cache.addCustomer("Miller", new HashSet(Arrays.asList(new PhoneNumber("0434855555"),new PhoneNumber("04445999999"))));
		
	}
	
}
