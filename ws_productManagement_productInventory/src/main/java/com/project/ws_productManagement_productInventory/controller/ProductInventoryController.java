package com.project.ws_productManagement_productInventory.controller;

import com.example.lib_productManagement_entity.entity.ProductInventoryEntity;
import com.project.ws_productManagement_productInventory.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @GetMapping("/quantity/{product_id}")
    public ResponseEntity<Map> getQuantity(@PathVariable(value = "product_id") int product_id) {
        return productInventoryService.getQuantity(product_id);
    }


    @PostMapping("/productId/{product_id}/priceOfProduct/{price_of_a_product}")
    private ResponseEntity<ProductInventoryEntity> saveProductInventory(@PathVariable(value = "product_id") int product_id,
                                                                        @PathVariable(value = "price_of_a_product") int price_of_a_product,
                                                                        @RequestBody ProductInventoryEntity productInventoryEntity) {

        return productInventoryService.saveProductInventoryDetails(product_id, price_of_a_product, productInventoryEntity);

    }
}
