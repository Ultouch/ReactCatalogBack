package com.erpcooli.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.erpcooli.catalog.config.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class)
public class ReactCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactCatalogApplication.class, args);
	}

}
