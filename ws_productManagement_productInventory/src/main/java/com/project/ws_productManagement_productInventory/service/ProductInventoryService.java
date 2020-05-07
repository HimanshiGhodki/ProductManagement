package com.project.ws_productManagement_productInventory.service;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.example.lib_productManagement_entity.entity.ProductInventoryEntity;
import com.project.ws_productManagement_productInventory.client.ProductInventoryClient;
import com.project.ws_productManagement_productInventory.exception.IdNotFoundException;
import com.project.ws_productManagement_productInventory.repository.ProductInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductInventoryService {

    @Autowired
    private ProductInventoryRepository productInventoryRepository;
    @Autowired
    ProductInventoryClient productInventoryClient;

    public ResponseEntity<Map> getQuantity(int product_id) {
        Optional<ProductInventoryEntity> productInventoryEntity = productInventoryRepository.findById(product_id);
        if(!productInventoryEntity.isPresent())
            throw new IdNotFoundException("No Product found for this id : "+product_id);
        else {
            Integer quantity_available = productInventoryEntity.get().getProduct_quantity_available();
            Map<String, Integer> respose = new HashMap<>();
            respose.put("product_id", product_id);
            respose.put("quantity_available", quantity_available);
            return ResponseEntity.ok(respose);
        }
    }

    public ResponseEntity<ProductInventoryEntity> saveProductInventoryDetails(int product_id, int price_of_a_product, ProductInventoryEntity productInventoryEntity) {
        ProductCatalogEntity productCatalogEntity = productInventoryClient.getProductCatalogProductId(product_id);
        System.out.println(productCatalogEntity);
        productInventoryEntity.setProduct_id(productCatalogEntity.getProduct_id());
        productInventoryEntity.setProductCatalogEntity(productCatalogEntity);
        productInventoryRepository.save(productInventoryEntity);
        productInventoryClient.addPriceOfProduct(product_id, price_of_a_product);
        return ResponseEntity.ok(productInventoryEntity);
    }
}
