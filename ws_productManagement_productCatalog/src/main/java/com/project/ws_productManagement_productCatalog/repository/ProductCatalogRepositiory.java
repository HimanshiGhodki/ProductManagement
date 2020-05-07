package com.project.ws_productManagement_productCatalog.repository;

import com.example.lib_productManagement_entity.entity.ProductCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogRepositiory extends JpaRepository<ProductCatalogEntity,Integer> {
}
