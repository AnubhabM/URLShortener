package com.bootCrud.URLShortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.bootCrud"})
@EntityScan("com.bootCrud.models")
@EnableJpaRepositories("com.bootCrud.repositories")
public class URLShortener {

	public static void main(String[] args) {
		SpringApplication.run(URLShortener.class, args);
	}

}

