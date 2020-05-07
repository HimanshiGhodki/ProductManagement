package com.project.ws_productManagement_productInventory.client;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.project.ws_productManagement_productInventory.connfiguration.RestTemplateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ProductInventoryClient {

    @Autowired
    private RestTemplateConfiguration restTemplateConfiguration;

    public void addPriceOfProduct(int product_id, int price_of_a_product){
        Map<String, Integer> parameter = new HashMap<>();
        parameter.put("product_id", product_id);
        parameter.put("price_of_a_product", price_of_a_product);
        String url = "http://localhost:8092/products/product-id/{product_id}/price-of-product/{price_of_a_product}";
        URI uri = restTemplateConfiguration.restTemplate().postForLocation(url, null, parameter);
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
