package com.project.ws_productManagement_productPricing.repository;

import com.example.lib_productManagement_entity.entity.ProductPricingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPricingRepository extends JpaRepository<ProductPricingEntity, Integer> {
}
