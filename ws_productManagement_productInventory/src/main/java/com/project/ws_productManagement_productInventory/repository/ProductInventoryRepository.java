package com.project.ws_productManagement_productInventory.repository;

import com.example.lib_productManagement_entity.entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventoryEntity,Integer> {
}
