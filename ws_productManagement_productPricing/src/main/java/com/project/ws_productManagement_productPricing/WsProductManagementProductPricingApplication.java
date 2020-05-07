package com.project.ws_productManagement_productPricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.project.ws_productManagement_productPricing",
		"com.project.lib_productManagement_productInventory_entity.entity"})
@EntityScan({"com.example.lib_productManagement_entity.entity"})
@EnableAutoConfiguration
public class WsProductManagementProductPricingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsProductManagementProductPricingApplication.class, args);

	}

}
