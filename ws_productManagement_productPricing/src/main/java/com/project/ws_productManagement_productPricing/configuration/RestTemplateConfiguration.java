package com.project.ws_productManagement_productPricing.configuration;

import com.example.lib_productManagement_entity.entity.ProductInventoryEntity;
import com.example.lib_productManagement_entity.entity.ProductPricingEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ProductInventoryEntity productInventoryEntity() {
        return new ProductInventoryEntity();
    }

    @Bean
    public ProductPricingEntity productPricingEntity(){
        return new ProductPricingEntity();
    }
}

