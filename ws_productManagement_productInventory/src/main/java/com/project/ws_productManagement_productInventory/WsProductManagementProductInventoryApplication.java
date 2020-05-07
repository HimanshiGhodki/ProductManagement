package com.project.ws_productManagement_productInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.lib_productManagement_entity.entity")
public class WsProductManagementProductInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsProductManagementProductInventoryApplication.class, args);
	}

}
