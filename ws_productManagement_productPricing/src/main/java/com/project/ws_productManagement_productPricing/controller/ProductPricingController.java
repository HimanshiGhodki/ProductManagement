package com.project.ws_productManagement_productPricing.controller;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import com.project.ws_productManagement_productPricing.service.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductPricingController {

    @Autowired
    ProductPricingService productPricingService;

    @GetMapping("/product-id/{product_id}/quantity-required/{quantity_required}")
    public ResponseEntity<Map> getProductPriceById(@PathVariable(value = "product_id") int product_id,
                                                   @PathVariable(value = "quantity_required") int quantity_required) {
        return productPricingService.getPrice(product_id, quantity_required);
    }

    @PostMapping("/product-id/{product_id}/price-of-product/{price_of_a_product}")
    public void setProductCostPerUnit(@PathVariable(value = "product_id") int product_id,
                                      @PathVariable(value = "price_of_a_product") int price_of_a_product){
        productPricingService.setProductCostPerUnit(product_id, price_of_a_product);
    }

}
