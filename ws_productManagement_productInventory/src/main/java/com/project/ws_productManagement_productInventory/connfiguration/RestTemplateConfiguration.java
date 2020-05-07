package com.project.ws_productManagement_productInventory.connfiguration;

/*
import com.project.ws_productManagement_productInventory.client.ProductInventoryClient;
*/
import com.project.ws_productManagement_productInventory.client.ProductInventoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ProductInventoryClient getAvailableProductFromPricingClient(){
        return new ProductInventoryClient();
    }
}
