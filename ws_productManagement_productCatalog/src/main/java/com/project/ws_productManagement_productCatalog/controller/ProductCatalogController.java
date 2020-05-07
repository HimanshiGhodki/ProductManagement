package com.project.ws_productManagement_productCatalog.controller;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.project.ws_productManagement_productCatalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogService productCatalogService;

    public ProductCatalogController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductCatalogEntity> getProductById(@PathVariable(value = "product_id") int product_id){
        ResponseEntity<ProductCatalogEntity> productCatalogEntity = productCatalogService.findById(product_id);
        return productCatalogEntity;
    }

    @PostMapping()
    private ResponseEntity<ProductCatalogEntity> saveProductCatalog(@Valid @RequestBody ProductCatalogEntity productEntity) {
        ProductCatalogEntity productCatalogEntity = productCatalogService.saveProductCatalogDetails(productEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{product_id}")
                .buildAndExpand(productCatalogEntity.getProduct_id()).toUri();
        return ResponseEntity.created(location).build();
    }

}
