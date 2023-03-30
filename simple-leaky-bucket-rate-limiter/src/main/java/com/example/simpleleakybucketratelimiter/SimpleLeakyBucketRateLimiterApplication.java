package com.example.simpleleakybucketratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SimpleLeakyBucketRateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleLeakyBucketRateLimiterApplication.class, args);
	}

}
