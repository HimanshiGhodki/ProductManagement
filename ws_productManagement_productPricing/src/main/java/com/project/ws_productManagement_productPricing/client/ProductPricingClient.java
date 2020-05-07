package com.project.ws_productManagement_productPricing.client;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.project.ws_productManagement_productPricing.configuration.RestTemplateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductPricingClient {

    @Autowired
    private RestTemplateConfiguration restTemplateConfiguration;

    public ProductPricingClient() {
    }

    public ProductPricingClient(RestTemplateConfiguration restTemplateConfiguration) {
        this.restTemplateConfiguration = restTemplateConfiguration;
    }

    public Integer getAvailabilityfromInventoryService(int product_id){
        Map<String, Integer> parameter = new HashMap<>();
        parameter.put("product_id", product_id);
        String url = "http://localhost:8091/products/quantity/{product_id}";
        ResponseEntity<Map> hashMapResponseEntity = restTemplateConfiguration.restTemplate()
                .exchange(url, HttpMethod.GET,null, Map.class, parameter);
        Map hashMap = hashMapResponseEntity.getBody();
        Integer quantity = (Integer) hashMap.get("quantity_available");
        return quantity;

    }

    public ProductCatalogEntity getProductCatalogProductId(Integer product_id){
        Map<String, Integer> parameter = new HashMap<>();
        parameter.put("product_id", product_id);
        String url = "http://localhost:8090/products/{product_id}";
        System.out.println("before client call");
        ResponseEntity<ProductCatalogEntity> productCatalogEntity = restTemplateConfiguration.restTemplate().getForEntity(url, ProductCatalogEntity.class, parameter);
        System.out.println("after client call");
        return productCatalogEntity.getBody();
    }
}