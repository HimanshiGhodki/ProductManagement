package com.project.ws_productManagement_productCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.lib_productManagement_entity.entity")
public class WsProductManagementProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsProductManagementProductCatalogApplication.class, args);
	}

}
