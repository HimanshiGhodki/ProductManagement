package com.project.ws_productManagement_productCatalog.service;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.project.ws_productManagement_productCatalog.exception.IdNotFoundException;
import com.project.ws_productManagement_productCatalog.repository.ProductCatalogRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCatalogService {
    @Autowired
    public ProductCatalogRepositiory productCatelogRepo;

    public ResponseEntity<ProductCatalogEntity> findById(int product_id) {
        Optional<ProductCatalogEntity> productCatalogEntity = productCatelogRepo.findById(product_id);
        if(!productCatalogEntity.isPresent())throw new IdNotFoundException("No Product found for this id: "+product_id);
        return ResponseEntity.of(productCatalogEntity);
    }

    public ProductCatalogEntity saveProductCatalogDetails(ProductCatalogEntity productCatalogEntity) {
        productCatelogRepo.save(productCatalogEntity);
        return productCatalogEntity;
    }
}
