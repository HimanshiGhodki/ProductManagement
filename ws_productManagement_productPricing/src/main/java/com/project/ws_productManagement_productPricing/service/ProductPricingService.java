package com.project.ws_productManagement_productPricing.service;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.example.lib_productManagement_entity.entity.ProductPricingEntity;
import com.project.ws_productManagement_productPricing.client.ProductPricingClient;
import com.project.ws_productManagement_productPricing.exception.IdNotFoundException;
import com.project.ws_productManagement_productPricing.repository.ProductPricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductPricingService {

    @Autowired
    ProductPricingRepository productPricingRepository;
    @Autowired
    private ProductPricingClient productPricingClient;
    @Autowired
    private ProductPricingEntity productPricingEntity;

    public ResponseEntity<Map> getPrice(int product_id, int quantity_required) {
        Optional<ProductPricingEntity> productPricingEntity = productPricingRepository.findById(product_id);
        if (!productPricingEntity.isPresent())
            throw new IdNotFoundException("No Product found for this id : "+product_id);
        Integer priceOfAProduct = productPricingEntity.get().getCost_per_product();
        Integer availability = productPricingClient.getAvailabilityfromInventoryService(product_id);
        if (availability >= quantity_required) {
            Integer price = priceOfAProduct * quantity_required;
            Map<String, Integer> response = new HashMap<>();
            response.put("product_id", product_id);
            response.put("quantity_required", quantity_required);
            response.put("price", price);
            return ResponseEntity.ok(response);
        } else {
            Map<String, Integer> response = new HashMap<>();
            response.put("product_id", product_id);
            response.put("quantity_required", quantity_required);
            response.put("quantity_available", availability);
            return ResponseEntity.ok(response);
        }
    }

    public void setProductCostPerUnit(int product_id, int price_of_a_product) {
        ProductCatalogEntity productCatalogEntity = productPricingClient.getProductCatalogProductId(product_id);
        productPricingEntity.setProduct_id(product_id);
        productPricingEntity.setProductCatalogEntity(productCatalogEntity);
        productPricingEntity.setCost_per_product(price_of_a_product);
        productPricingRepository.save(productPricingEntity);
    }
}
