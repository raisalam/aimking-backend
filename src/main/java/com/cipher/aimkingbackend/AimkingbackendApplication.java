package com.cipher.aimkingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AimkingbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AimkingbackendApplication.class, args);
	}

}
